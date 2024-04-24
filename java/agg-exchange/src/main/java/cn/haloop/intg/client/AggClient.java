package cn.haloop.intg.client;

import cn.haloop.intg.collect.CluePushRequest;
import cn.haloop.intg.collect.CluePushResponse;
import cn.haloop.intg.collect.ClueUpdateRequest;
import cn.haloop.intg.collect.ClueUpdateResponse;
import cn.haloop.intg.improve.ClueImproveRequest;
import cn.haloop.intg.improve.ClueImproveResponse;

/**
 * 数据推送接口
 *
 * @author yangtuo
 */
public interface AggClient {

  /**
   * 推送线索
   *
   * @param request 线索推送请求
   * @return 推送结果
   * @throws Exception 推送异常
   */
  CluePushResponse push(CluePushRequest request) throws Exception;

  /**
   * 更新线索
   *
   * @param request 线索更新请求
   * @return 更新结果
   * @throws Exception 更新异常
   */
  ClueUpdateResponse update(ClueUpdateRequest request) throws Exception;

  /**
   * 完善线索信息
   *
   * @param request 完善线索请求
   * @return 完善结果
   * @throws Exception 完善异常
   */
  ClueImproveResponse improve(ClueImproveRequest request) throws Exception;

}
