package cn.haloop.intg.demo.builder;

import cn.haloop.intg.collect.ClueCollection;
import cn.haloop.intg.collect.CluePushRequest;
import cn.haloop.intg.enums.Gender;
import cn.haloop.intg.mock.Clue;
import lombok.RequiredArgsConstructor;

/**
 * @author yangtuo
 */
@RequiredArgsConstructor
public class CluePushRequestBuilder {

  private final Clue clue;

  public CluePushRequest build() {
    ClueCollection collection = new ClueCollection();
    collection.setRealTimePush(clue.isRealTimePush());
    collection.setSpecifiedAppCode(clue.getSpecifiedAppCode());
    collection.setCustomerName(clue.getCustomerName());
    collection.setGender(Gender.of(clue.getGender()));
    collection.setPhone(clue.getPhone());
    collection.setIdCardNo(clue.getIdCardNo());
    collection.setResidentPlace(clue.getResidentPlace());
    collection.setProvinceCode(clue.getProvinceCode());
    collection.setCityCode(clue.getCityCode());
    collection.setAreaCode(clue.getAreaCode());
    collection.setBirthYear(clue.getBirthYear());
    collection.setBirthMonth(clue.getBirthMonth());
    collection.setBirthDay(clue.getBirthDay());
    collection.setAge(clue.getAge());
    collection.setAgeRange(clue.getAgeRange());
    collection.setPreviouslyInsured(clue.getPreviouslyInsured());
    collection.setConsultingNeeds(clue.getConsultingNeeds());
    collection.setInsuranceBudget(clue.getInsuranceBudget());
    collection.setFamilyAnnualIncome(clue.getFamilyAnnualIncome());
    collection.setPersonalAnnualIncome(clue.getPersonalAnnualIncome());
    collection.setChannelCode(clue.getChannelCode());
    collection.setSubChannelCode(clue.getSubChannelCode());
    collection.setClueGrade(clue.getClueGrade());

    return new CluePushRequest(collection);
  }
}
