package cn.haloop.intg.demo.builder;

import cn.haloop.intg.collect.ClueCollection;
import cn.haloop.intg.collect.ClueUpdateRequest;
import cn.haloop.intg.enums.Gender;
import cn.haloop.intg.mock.Clue;
import lombok.RequiredArgsConstructor;

/**
 * @author yangtuo
 */
@RequiredArgsConstructor
public class ClueUpdateRequestBuilder {

  private final Clue clue;

  public ClueUpdateRequest build() {
    ClueCollection collection = new ClueCollection();
    collection.setClueId(clue.getClueId());
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
    collection.setProductCode(clue.getProductCode());
    collection.setProductVersion(clue.getProductVersion());
    collection.setTags(clue.getTags());
    collection.setExt(clue.getExt());

    return new ClueUpdateRequest(collection);
  }
}
