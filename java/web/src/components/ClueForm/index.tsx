import React, {useEffect, useState} from "react";
import {Button, Col, Form, Input, InputNumber, Radio, Row, Space, Switch} from "antd";


type SubmitType = "create" | "update"

export type SubmitData = {
  submitType: SubmitType
  clueData: ClueData
}

export type ClueData = {
  clueId?: string
  realTimePush?: boolean
  specifiedAppCode?: string
  customerName?: string
  gender?: number
  phone?: string
  idCardNo?: string
  residentPlace?: string
  provinceCode?: string
  cityCode?: string
  areaCode?: string
  birthYear?: number
  birthMonth?: number
  birthDay?: number
  age?: number
  ageRange?: string
  previouslyInsured?: string
  consultingNeeds?: string
  insuranceBudget?: string
  familyAnnualIncome?: string
  personalAnnualIncome?: string
  channelCode?: string
  subChannelCode?: string
  clueGrade?: string
  ext?: Record<string, any>
}

type ClueFormProps = {
  onFinish: (values: SubmitData) => void
  initialValues?: ClueData
}

const ClueForm: React.FC<ClueFormProps> = ({onFinish, initialValues}) => {

  const [form] = Form.useForm()
  const [submitType, setSubmitType] = React.useState<SubmitType>("create")
  const [realTimePush, setRealTimePush] = useState<boolean>(false)

  const onRest = () => {
    form.resetFields()
    setSubmitType('create')
    setRealTimePush(false)
  }

  useEffect(() => {
    if (initialValues) {
      const data: SubmitData = {
        submitType: "create",
        clueData: initialValues
      }
      form.setFieldsValue(data)
    }
  }, [form, initialValues])

  return (
      <>
        <Form
            form={form}
            name={"clueForm"}
            labelCol={{span: 10}}
            wrapperCol={{span: 20}}
            style={{maxWidth: 1000}}
            onFinish={onFinish}
        >
          <Row gutter={24}>
            <Col span={12}>
              <Form.Item<SubmitData> label="姓名" name={["clueData", "customerName"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="性别" name={["clueData", "gender"]}>
                <Radio.Group>
                  <Radio value={0}>未知</Radio>
                  <Radio value={1}>男</Radio>
                  <Radio value={2}>女</Radio>
                </Radio.Group>
              </Form.Item>
              <Form.Item<SubmitData> label="电话" name={["clueData", "phone"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="身份证号" name={["clueData", "idCardNo"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="年龄" name={["clueData", "age"]}>
                <InputNumber/>
              </Form.Item>
              <Form.Item<SubmitData> label="年龄范围" name={["clueData", "ageRange"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="出生年" name={["clueData", "birthYear"]}>
                <InputNumber/>
              </Form.Item>
              <Form.Item<SubmitData> label="出生月" name={["clueData", "birthMonth"]}>
                <InputNumber/>
              </Form.Item>
              <Form.Item<SubmitData> label="出生日" name={["clueData", "birthDay"]}>
                <InputNumber/>
              </Form.Item>
              <Form.Item<SubmitData> label="所在地" name={["clueData", "residentPlace"]}>
                <Input/>
              </Form.Item>
            </Col>
            <Col span={12}>
              <Form.Item<SubmitData> label="省编码" name={["clueData", "provinceCode"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="市编码" name={["clueData", "cityCode"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="区编码" name={["clueData", "areaCode"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="是否购买过保险" name={["clueData", "previouslyInsured"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="感兴趣的产品" name={["clueData", "consultingNeeds"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="保险预算" name={["clueData", "insuranceBudget"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="家庭年收入" name={["clueData", "familyAnnualIncome"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="个人年收入" name={["clueData", "personalAnnualIncome"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="渠道编码" name={["clueData", "channelCode"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="子渠道编码" name={["clueData", "subChannelCode"]}>
                <Input/>
              </Form.Item>
              <Form.Item<SubmitData> label="线索等级" name={["clueData", "clueGrade"]}>
                <Input/>
              </Form.Item>
              {
                  submitType === 'create' && (
                      <Form.Item<SubmitData> label="是否实时推送" name={["clueData", "realTimePush"]}>
                        <Switch checkedChildren='实时' unCheckedChildren='非实时' defaultValue={false} onChange={(e) => {
                          setRealTimePush(e)
                        }}/>
                      </Form.Item>
                  )
              }

              {
                  submitType === 'create' && realTimePush && (
                      <Form.Item label={"指定接收的机构appCode"} name={["clueData", "specifiedAppCode"]}>
                        <Input/>
                      </Form.Item>
                  )
              }
            </Col>
          </Row>

          <Form.List name={["clueData", "ext"]}>
            {(fields, { add, remove }) => (
                <>
                  {fields.map(({ key, name, fieldKey, ...restField }) => (
                      <Row key={key} gutter={24}>
                        <Col span={10}>
                          <Form.Item
                              {...restField}
                              label="字段名"
                              name={[name, 'key']}
                              fieldKey={["ext", key, "key"]}
                              rules={[{ required: true, message: '请输入字段名' }]}
                          >
                            <Input placeholder="字段名" />
                          </Form.Item>
                        </Col>
                        <Col span={10}>
                          <Form.Item
                              {...restField}
                              label="字段值"
                              name={[name, 'value']}
                              fieldKey={["ext", key, "value"]}
                              rules={[{ required: true, message: '请输入字段值' }]}
                          >
                            <Input placeholder="字段值" />
                          </Form.Item>
                        </Col>
                        <Col span={4}>
                          <Button onClick={() => remove(name)}>删除</Button>
                        </Col>
                      </Row>
                  ))}
                  <Form.Item wrapperCol={{offset: 10, span: 20}}>
                    <Button type="dashed" onClick={() => add()} block>
                      添加扩展字段
                    </Button>
                  </Form.Item>
                </>
            )}
          </Form.List>

          <Form.Item<SubmitData> wrapperCol={{offset: 10, span: 20}} name="submitType">
            <Radio.Group onChange={(e) => setSubmitType(e.target.value)} defaultValue={'create'}>
              <Radio value={"create"}>创建</Radio>
              <Radio value={"update"}>更新</Radio>
            </Radio.Group>
          </Form.Item>

          {
              submitType === "update"
              && (
                  <Form.Item label={"线索ID"} name={["clueData", "clueId"]}>
                    <Input/>
                  </Form.Item>
              )
          }

          <Form.Item wrapperCol={{offset: 10, span: 20}}>
            <Space>
              <Button type="primary" htmlType="submit">提交</Button>
              <Button type={"default"} htmlType={"button"} onClick={onRest}>
                重置
              </Button>
            </Space>
          </Form.Item>
        </Form>
      </>
  )
}

export default ClueForm