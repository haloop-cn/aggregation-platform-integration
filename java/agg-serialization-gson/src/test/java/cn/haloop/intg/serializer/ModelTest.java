package cn.haloop.intg.serializer;

import cn.haloop.intg.collect.ClueCollection;
import cn.haloop.intg.enums.Gender;
import cn.haloop.intg.mock.Clue;
import cn.haloop.intg.mock.RandomClue;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yangtuo
 */
public class ModelTest {

  private final AggSerializer serializer = new AggGsonSerializerFactory().create();

  @Test
  void testClue() throws IOException {
    RandomClue randomClue = new RandomClue();
    Clue clue = randomClue.next();

    String json = serializer.serialize(clue);
    Clue restored = serializer.deserialize(json, Clue.class);

    Assertions.assertEquals(clue.getPhone(), restored.getPhone());
    Assertions.assertEquals(clue.getPhone().hashCode(), restored.getPhone().hashCode());
  }

  @Test
  void testGender() throws IOException {
    ClueCollection clue = new ClueCollection();
    clue.setGender(Gender.MALE);

    String json = serializer.serialize(clue);
    Assertions.assertEquals("{\"gender\":1}", json);

    ClueCollection restored = serializer.deserialize(json, ClueCollection.class);
    Assertions.assertEquals(clue.getGender(), restored.getGender());
  }

}
