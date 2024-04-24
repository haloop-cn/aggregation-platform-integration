package cn.haloop.intg.collect;

import cn.haloop.intg.client.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 线索推送请求
 *
 * @author yangtuo
 */
@Getter
@Setter
public class CluePushRequest extends BaseRequest<ClueCollection> {

  public CluePushRequest(ClueCollection data) {
    super(data);
  }

  @Override
  public String[] pathSegments() {
    return new String[]{"open", "clue", "push"};
  }

}
