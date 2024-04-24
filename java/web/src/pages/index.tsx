import React from "react";
import ClueForm, {ClueData, SubmitData} from "@/components/ClueForm";
import {Button, message, Tabs} from "antd";
import {randomClue, submitClue, updateClue} from "@/api/clue";


const Home = () => {

  const [clueData, setClueData] = React.useState<ClueData>({})
  const [response, setResponse] = React.useState<any>({})

  const onFinish = (value: SubmitData) => {
    if (value.submitType === 'create') {
      submitClue(value.clueData).then((res) => {
        setResponse(res)
        return message.success('提交成功')
      }).catch((err) => {
        setResponse(err)
        return message.error(err)
      })
    }

    if (value.submitType === 'update') {
      updateClue(value.clueData).then((res) => {
        setResponse(res)
        return message.success('更新成功')
      }).catch((err) => {
        setResponse(err)
        return message.error(err)
      })
    }
  }


  const onRandom = () => {
    randomClue().then((res) => {
      setClueData(res)
    }).catch((err) => {
      return message.error(err)
    })
  }

  return (
      <>
        <Button type={"primary"} onClick={onRandom}>随机生成</Button>
        <ClueForm onFinish={onFinish} initialValues={clueData}/>
        <Tabs>
          <Tabs.TabPane tab={"响应报文"} key={"1"}>
            <pre>{JSON.stringify(response, null, 2)}</pre>
          </Tabs.TabPane>
        </Tabs>
      </>
  )
}

export default Home