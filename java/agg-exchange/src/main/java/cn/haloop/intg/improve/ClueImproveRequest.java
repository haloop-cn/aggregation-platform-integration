package cn.haloop.intg.improve;

import cn.haloop.intg.client.BaseRequest;

/**
 * 线索完善请求
 *
 * @author yangtuo
 */
public class ClueImproveRequest extends BaseRequest<ClueImprovement> {

  public ClueImproveRequest(ClueImprovement data) {
    super(data);
  }

  @Override
  public String[] pathSegments() {
    return new String[]{"open", "clue", "perfect"};
  }
}
