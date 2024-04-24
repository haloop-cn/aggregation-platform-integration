package cn.haloop.intg.collect;

import cn.haloop.intg.client.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yangtuo
 */
@Getter
@Setter
public class ClueUpdateRequest extends BaseRequest<ClueCollection> {

  public ClueUpdateRequest(ClueCollection data) {
    super(data);
  }

  @Override
  public String[] pathSegments() {
    return new String[]{"open", "clue", "update"};
  }
}
