package cn.haloop.intg.demo.controller;

import cn.haloop.intg.collect.ClueCollectionResponseData;
import cn.haloop.intg.demo.model.Clue;
import cn.haloop.intg.demo.service.AggService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangtuo
 */
@Tag(
    name = "线索管理",
    description = "用于测试线索管理的接口，包含线索的生成、推送等功能"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/agg")
public class AggController {

  private final AggService svc;

  @Operation(
      operationId = "ping",
      summary = "测试服务是否正常",
      description = "用于测试服务是否正常"
  )
  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  @Operation(
      operationId = "random",
      summary = "生成随机线索",
      description = "根据种子库生成随机的线索信息"
  )
  @GetMapping("/random")
  public ResponseEntity<Clue> random() {
    return ResponseEntity.ok(svc.random());
  }

  @Operation(
      operationId = "randomPush",
      summary = "生成随机线索并推送",
      description = "根据种子库生成随机的线索信息，并推送到指定的推送地址"
  )
  @PostMapping("/random-push")
  public ResponseEntity<ClueCollectionResponseData> randomPush() throws Exception {
    return ResponseEntity.ok(svc.randomPush());
  }

  @Operation(
      operationId = "push",
      summary = "推送线索",
      description = "推送指定的线索信息到指定的推送地址"
  )
  @PostMapping("/push")
  public ResponseEntity<ClueCollectionResponseData> push(@RequestBody Clue clue) throws Exception {
    return ResponseEntity.ok(svc.push(clue));
  }

  @Operation(
      operationId = "updateClue",
      summary = "更新线索",
      description = "更新指定的线索信息"
  )
  @PutMapping("/update")
  public ResponseEntity<ClueCollectionResponseData> update(@RequestBody Clue clue) throws Exception {
    return ResponseEntity.ok(svc.update(clue));
  }
}
