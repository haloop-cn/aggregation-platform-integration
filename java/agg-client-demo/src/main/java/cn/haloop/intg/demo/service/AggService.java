package cn.haloop.intg.demo.service;

import cn.haloop.intg.client.AggClient;
import cn.haloop.intg.collect.ClueCollectionResponseData;
import cn.haloop.intg.collect.CluePushRequest;
import cn.haloop.intg.collect.CluePushResponse;
import cn.haloop.intg.collect.ClueUpdateRequest;
import cn.haloop.intg.collect.ClueUpdateResponse;
import cn.haloop.intg.demo.builder.CluePushRequestBuilder;
import cn.haloop.intg.demo.builder.ClueUpdateRequestBuilder;
import cn.haloop.intg.demo.exception.BusinessException;
import cn.haloop.intg.mock.Clue;
import cn.haloop.intg.mock.RandomClue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author yangtuo
 */
@Service
@RequiredArgsConstructor
public class AggService {

  private final AggClient client;

  private final RandomClue randomClue = new RandomClue();

  public Clue random() {
    return randomClue.next();
  }

  public ClueCollectionResponseData randomPush() throws Exception {
    Clue clue = randomClue.next();
    CluePushRequest request = new CluePushRequestBuilder(clue).build();
    CluePushResponse response = client.push(request);
    if (!response.isSuccess()) {
      throw new BusinessException("线索推送失败: " + response.getMsg());
    }
    return response.getData();
  }

  public ClueCollectionResponseData push(Clue clue) throws Exception {
    CluePushRequest request = new CluePushRequestBuilder(clue).build();
    CluePushResponse response = client.push(request);
    if (!response.isSuccess()) {
      throw new BusinessException("线索推送失败: " + response.getMsg());
    }
    return response.getData();
  }

  public ClueCollectionResponseData update(Clue clue) throws Exception {
    ClueUpdateRequest request = new ClueUpdateRequestBuilder(clue).build();
    ClueUpdateResponse response = client.update(request);
    if (!response.isSuccess()) {
      throw new BusinessException("线索更新失败: " + response.getMsg());
    }
    return response.getData();
  }
}
