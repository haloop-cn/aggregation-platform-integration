package cn.haloop.intg.mock;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yangtuo
 */
@Getter
@Setter
public class Clue {

  /**
   * 线索id
   */
  private String clueId;

  /**
   * 是否实时推送
   */
  private boolean realTimePush;

  /**
   * 指定接收的app-code
   */
  private String specifiedAppCode;

  /**
   * 客户姓名
   */
  private String customerName;

  /**
   * 性别：0-未知，1-男，2-女
   */
  private Integer gender;

  /**
   * 手机号
   */
  private String phone;

  /**
   * 客户所在地
   */
  private String residentPlace;

  /**
   * 常驻省code
   */
  private String provinceCode;

  /**
   * 常驻市code
   */
  private String cityCode;

  /**
   * 常驻区code
   */
  private String areaCode;

  /**
   * 出生年
   */
  private Integer birthYear;

  /**
   * 出生月
   */
  private Integer birthMonth;

  /**
   * 出生日
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
   * 感兴趣的保险产品
   */
  private String consultingNeeds;

  /**
   * 保险预算
   */
  private String insuranceBudget;

  /**
   * 个人年收入
   */
  private String personalAnnualIncome;

  /**
   * 家庭年收入
   */
  private String familyAnnualIncome;

  /**
   * 授权机构
   */
  private String authorizedOrganization;

  /**
   * 渠道code
   */
  private String channelCode;

  /**
   * 子渠道
   */
  private String subChannelCode;

  /**
   * 线索层级
   */
  private String clueGrade;

  /**
   * 身份证号
   */
  private String idCardNo;

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
