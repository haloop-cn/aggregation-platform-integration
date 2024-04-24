package cn.haloop.intg.improve;

import cn.haloop.intg.enums.Gender;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * 线索完善
 *
 * @author yangtuo
 */
@Getter
@Setter
public class ClueImprovement {

  /**
   * 线索完善任务id，线索由表单聚合平台推送该给第三方时分发的任务id
   */
  private Long taskId;

  /**
   * 完善后的线索信息
   */
  private ClueInfo clue;

  /**
   * 线索完善信息
   */
  @Getter
  @Setter
  static class ClueInfo {

    /**
     * 线索id
     */
    private Long clueId;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户性别
     */
    private Gender gender;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 手机号
     */
    private String telephone;

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
     * 地区编码
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
     * 渠道
     */
    private Integer channel;

    /**
     * 子渠道编码
     */
    private String subChannel;

    /**
     * 线索等级
     */
    private String clueGrade;

    /**
     * 备注信息
     */
    private Map<String, Object> remark;

    /**
     * 线索表单信息
     */
    private ClueForm formInfo;
  }

  /**
   * 线索表单信息
   */
  @Getter
  @Setter
  static class ClueForm {

    /**
     * 婚姻状态
     */
    private String marriageStatus;

    /**
     * 年龄
     */
    private String age;

    /**
     * 年龄范围
     */
    private String ageRange;

    /**
     * 最近异常体检结果是否正常
     */
    private String physicalExaminationResult;

    /**
     * 所属行业
     */
    private String industryInvolved;

    /**
     * 个人年收入
     */
    private String annualIncome;

    /**
     * 家庭年收入
     */
    private String familyAnnualIncome;

    /**
     * 投保人占家庭收入占比
     */
    private String revenuePercentage;

    /**
     * 家庭年支出
     */
    private String householdAnnualExpenses;

    /**
     * 居住地是否有车辆资产
     */
    private String vehicleAssets;

    /**
     * 居住地是否有住房
     */
    private String fixedProperty;

    /**
     * 是否为家人投保
     */
    private String insureFamily;

    /**
     * 是否买过保险
     */
    private String purchasedInsurance;

    /**
     * 是否正在理赔
     */
    private String settleClaims;

    /**
     * 关注领域
     */
    private String focusDirection;

    /**
     * 已买保费总额
     */
    private String insurancePremium;

    /**
     * 已买短险数
     */
    private String shortPolicyCount;

    /**
     * 已买健康险数
     */
    private String healthPolicyCount;

    /**
     * 已买寿险数
     */
    private String lifePolicyCount;

    /**
     * 已买年金险数
     */
    private String annuityPolicyCount;

    /**
     * 已买重疾险数
     */
    private String criticalIllnessPolicyCount;

    /**
     * 已买意外险数
     */
    private String casualtyPolicyCount;

    /**
     * 感兴趣的产品
     */
    private String consultingNeeds;

    /**
     * 保险预算
     */
    private String insuranceBudget;

    /**
     * 为谁投保
     */
    private String insureWho;

    /**
     * 想要了解的内容
     */
    private String wantToKnow;

    /**
     * 期望联系时间
     */
    private String expectContactTime;

  }
}
