package cn.haloop.intg.demo.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yangtuo
 */
public class Region {

  private final ObjectMapper om = new ObjectMapper();
  private List<Division> divisions;

  public Region() {

  }


  public void load() throws IOException {
    URL resource = this.getClass().getClassLoader().getResource("region/pca-code.json");
    this.divisions = om.readValue(resource, new TypeReference<List<Division>>() {
    });
  }

  @Getter
  @Setter
  public static class Division {

    private String code;
    private String name;
    private final List<Division> children = new ArrayList<>();


    public Division randomCity() {
      return children.get((int) (Math.random() * children.size()));
    }

    public Division randomArea() {
      return children.get((int) (Math.random() * children.size()));
    }
  }

  public Division randomProvince() {
    return divisions.get((int) (Math.random() * divisions.size()));
  }
}
