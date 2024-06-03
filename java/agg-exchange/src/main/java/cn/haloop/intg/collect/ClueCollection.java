package cn.haloop.intg.collect;

import cn.haloop.intg.enums.Gender;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * 线索信息
 *
 * @author yangtuo
 */
@Getter
@Setter
public class ClueCollection {

  /**
   * 线索id
   */
  private String clueId;

  /**
   * 是否实时推送
   */
  private Boolean realTimePush;

  /**
   * 指定接收线索的appCode
   */
  private String specifiedAppCode;

  /**
   * 客户姓名
   */
  private String customerName;

  /**
   * 性别
   */
  private Gender gender;

  /**
   * 手机号
   */
  private String phone;

  /**
   * 身份证号
   */
  private String idCardNo;

  /**
   * 客户所在地
   */
  private String residentPlace;

  /**
   * 省份编码
   */
  private String provinceCode;

  /**
   * 城市编码
   */
  private String cityCode;

  /**
   * 区域编码
   */
  private String areaCode;

  /**
   * 出生年份
   */
  private Integer birthYear;

  /**
   * 出生月份
   */
  private Integer birthMonth;

  /**
   * 出生日期
   */
  private Integer birthDay;

  /**
   * 年龄
   */
  private Integer age;

  /**
   * 年龄范围
   */
  private String ageRange;

  /**
   * 是否购买过保险
   */
  private String previouslyInsured;

  /**
   * 感兴趣的产品
   */
  private String consultingNeeds;

  /**
   * 保险预算
   */
  private String insuranceBudget;

  /**
   * 家庭年收入
   */
  private String familyAnnualIncome;

  /**
   * 个人年收入
   */
  private String personalAnnualIncome;

  /**
   * 渠道编码
   */
  private String channelCode;

  /**
   * 子渠道编码
   */
  private String subChannelCode;

  /**
   * 线索等级
   */
  private String clueGrade;

  /**
   * 产品编码
   */
  private String productCode;

  /**
   * 产品版本
   */
  private String productVersion;

  /**
   * 标签
   */
  private List<String> tags;

  /**
   * 扩展字段
   */
  private Map<String, Object> ext;

}
