package cn.haloop.intg.demo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtuo
 */
public class Seed {

  private final static List<String> ageRanges = new ArrayList<>();
  private final static List<String> consultingNeeds = new ArrayList<>();
  private final static List<String> insuranceBudgets = new ArrayList<>();
  private final static List<String> annualIncomes = new ArrayList<>();
  private final static List<String> clueGrades = new ArrayList<>();

  static {
    initAgeRanges();
    initConsultingNeeds();
    initInsuranceBudgets();
    initAnnualIncomes();
    initClueGrades();
  }


  public static String randomAnnualIncome() {
    return annualIncomes.get((int) (Math.random() * annualIncomes.size()));
  }


  public static String randomInsuranceBudget() {
    return insuranceBudgets.get((int) (Math.random() * insuranceBudgets.size()));
  }

  public static String randomAgeRange() {
    return ageRanges.get((int) (Math.random() * ageRanges.size()));
  }

  public static String randomPreviouslyInsured() {
    return Math.random() > 0.5 ? "是" : "否";
  }

  public static List<String> randomConsultingNeeds(int max) {
    List<String> needs = new ArrayList<>();
    int size = (int) (Math.random() * consultingNeeds.size());
    if (size > max) {
      size = max;
    }
    for (int i = 0; i < size; i++) {
      needs.add(consultingNeeds.get((int) (Math.random() * consultingNeeds.size())));
    }
    return needs;
  }

  private static void initConsultingNeeds() {
    consultingNeeds.add("投资理财");
    consultingNeeds.add("家庭财务规划");
    consultingNeeds.add("健康保险");
    consultingNeeds.add("重大疾病保险");
    consultingNeeds.add("意外保险");
    consultingNeeds.add("寿险");
    consultingNeeds.add("教育金");
    consultingNeeds.add("养老金");
  }

  private static void initAgeRanges() {
    ageRanges.add("20岁-30岁");
    ageRanges.add("30岁-40岁");
    ageRanges.add("40岁-50岁");
    ageRanges.add("40岁以上");
  }

  private static void initInsuranceBudgets() {
    insuranceBudgets.add("1万以下");
    insuranceBudgets.add("1万-5万");
    insuranceBudgets.add("5万-10万");
    insuranceBudgets.add("10万-20万");
    insuranceBudgets.add("20万以上");
  }

  private static void initAnnualIncomes() {
    annualIncomes.add("5万以下");
    annualIncomes.add("5万-10万");
    annualIncomes.add("10万-20万");
    annualIncomes.add("20万-50万");
    annualIncomes.add("50万以上");
  }

  private static void initClueGrades() {
    clueGrades.add("S");
    clueGrades.add("A");
    clueGrades.add("B");
    clueGrades.add("C");
  }

  public static String randomClueGrade() {
    return clueGrades.get((int) (Math.random() * clueGrades.size()));
  }
}
