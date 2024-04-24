package cn.haloop.intg.demo.model;


import cn.haloop.intg.demo.model.Region.Division;
import com.github.javafaker.Faker;
import java.io.IOException;
import java.util.Locale;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yangtuo
 */
@Getter
@Setter
public class RandomClue {

  private final Faker faker = new Faker(Locale.CHINA);
  private final Region region = new Region();

  public RandomClue() {

    try {
      region.load();
    } catch (IOException e) {
      // NOOP
    }
  }

  /**
   * 返回一个完整的线索信息
   */
  public Clue next() {
    Clue clue = new Clue();
    clue.setCustomerName(faker.name().name());
    clue.setGender(faker.number().numberBetween(0, 2));
    clue.setPhone(faker.phoneNumber().cellPhone());
    clue.setBirthYear(faker.number().numberBetween(1950, 2000));
    clue.setBirthMonth(faker.number().numberBetween(1, 13));
    clue.setBirthDay(faker.number().numberBetween(1, 32));

    Division province = region.randomProvince();
    Division city = province.randomCity();
    Division area = city.randomArea();

    clue.setResidentPlace(String.join("-", province.getName(), city.getName(), area.getName()));
    clue.setProvinceCode(province.getCode());
    clue.setCityCode(city.getCode());
    clue.setAreaCode(area.getCode());
    clue.setAge(faker.number().numberBetween(18, 60));
    clue.setAgeRange(Seed.randomAgeRange());

    clue.setPreviouslyInsured(Seed.randomPreviouslyInsured());
    String consultingNeeds = String.join(",", Seed.randomConsultingNeeds(3));
    clue.setConsultingNeeds(consultingNeeds);
    clue.setInsuranceBudget(Seed.randomInsuranceBudget());
    clue.setPersonalAnnualIncome(Seed.randomAnnualIncome());
    clue.setFamilyAnnualIncome(Seed.randomAnnualIncome());
    clue.setAuthorizedOrganization("v1");
    clue.setChannelCode("xhb");
    clue.setSubChannelCode("tf");
    clue.setClueGrade(Seed.randomClueGrade());
    return clue;
  }

  /**
   * 返回一个仅包含最小可行的线索信息
   */
  public Clue nextMinimal() {
    Clue clue = new Clue();
    clue.setPhone(faker.phoneNumber().cellPhone());
    clue.setChannelCode(faker.code().ean8());
    clue.setSubChannelCode(faker.code().ean8());
    return clue;
  }

  public Clue next(String randomType) {
    if ("minimal".equals(randomType)) {
      return nextMinimal();
    }
    return next();
  }
}
