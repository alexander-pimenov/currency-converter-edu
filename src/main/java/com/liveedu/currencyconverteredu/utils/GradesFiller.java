package com.liveedu.currencyconverteredu.utils;

//import com.epam.beamery.dto.CustomField;
//import com.epam.beamery.model.Interview;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Class to calculate interview grades for candidates.
 */
@UtilityClass
public class GradesFiller {
    //interview types
    public final static String SCREENING = "screening";
    public final static String REGULAR = "regular";
    public final static String AA = "AA";
    private final static String NO_HIRE_TRUE = "True";
    private final static String NO_HIRE_FALSE = "False";
    private final static String EMPTY_GRADE = "Empty";

    //display names
    //Last interview
    public static final String SCREENING_MAX = "Screening MAX";
    public static final String SCREENING_MIN = "Screening MIN";
    public static final String SCREENING_MEDIAN = "Screening MEDIAN";
    public static final String REGULAR_MAX = "Regular MAX";
    public static final String REGULAR_MIN = "Regular MIN";
    public static final String REGULAR_MEDIAN = "Regular MEDIAN";
    public static final String AA_MAX = "AA MAX";
    public static final String AA_MIN = "AA MIN";
    public static final String AA_MEDIAN = "AA MEDIAN";
    public static final String LAST_REGULAR_NO_HIRE = "Last Regular No Hire";
    public static final String LAST_AA_NO_HIRE = "Last AA No Hire";
    //All interviews
    public static final String ALL_SCREENING_MAX = "All Screening MAX";
    public static final String ALL_SCREENING_MIN = "All Screening MIN";
    public static final String ALL_SCREENING_MEDIAN = "All Screening MEDIAN";
    public static final String ALL_REGULAR_MAX = "All Regular MAX";
    public static final String ALL_REGULAR_MIN = "All Regular MIN";
    public static final String ALL_REGULAR_MEDIAN = "All Regular MEDIAN";
    public static final String ALL_AA_MAX = "All AA MAX";
    public static final String ALL_AA_MIN = "All AA MIN";
    public static final String ALL_AA_MEDIAN = "All AA MEDIAN";
    public static final String ALL_REGULAR_NO_HIRE = "All Regular No Hire";
    public static final String ALL_AA_NO_HIRE = "All AA No Hire";

    /**
     * Fill grades.
     */
//    public static List<CustomField> getGrades(List<Interview> interviews) {
//        interviews = interviews == null ? Collections.emptyList() : interviews;
//        List<CustomField> customFieldsStore = new ArrayList<>();
//        customFieldsStore.addAll(getAllInterviewGrades(interviews));
//        customFieldsStore.addAll(getLastInterviewGrades(interviews));
//        return customFieldsStore;
//    }
//
//    /**
//     * Returns {@link CustomField} list of populated grades for last consideration interviews.
//     */
//    private static List<CustomField> getLastInterviewGrades(List<Interview> interviews) {
//        var screeningMax = new CustomField(SCREENING_MAX, EMPTY_GRADE);
//        var screeningMin = new CustomField(SCREENING_MIN, EMPTY_GRADE);
//        var screeningMedian = new CustomField(SCREENING_MEDIAN, EMPTY_GRADE);
//        var regularMax = new CustomField(REGULAR_MAX, EMPTY_GRADE);
//        var regularMin = new CustomField(REGULAR_MIN, EMPTY_GRADE);
//        var regularMedian = new CustomField(REGULAR_MEDIAN, EMPTY_GRADE);
//        var lastRegularNoHire = new CustomField(LAST_REGULAR_NO_HIRE, EMPTY_GRADE);
//        var aaMax = new CustomField(AA_MAX, EMPTY_GRADE);
//        var aaMin = new CustomField(AA_MIN, EMPTY_GRADE);
//        var aaMedian = new CustomField(AA_MEDIAN, EMPTY_GRADE);
//        var lastAANoHire = new CustomField(LAST_AA_NO_HIRE, EMPTY_GRADE);
//
//        List<CustomField> customFieldsStore = new ArrayList<>(List.of(screeningMax, screeningMin, screeningMedian,
//                regularMax, regularMin, regularMedian, lastRegularNoHire, aaMax, aaMin, aaMedian, lastAANoHire));
//
//        Optional<Long> maxConsiderationId = interviews.stream()
//                .sorted(Comparator.comparing(Interview::getConsiderationCreated).thenComparing(Interview::getConsiderationId))
//                .reduce((first, second) -> second)
//                .map(Interview::getConsiderationId);
//        List<Interview> lastConsiderationInterviews = null;
//        if (maxConsiderationId.isPresent()) {
//            lastConsiderationInterviews = interviews.stream()
//                    .filter(interview -> interview.getConsiderationId() == maxConsiderationId.get())
//                    .collect(Collectors.toList());
//
//            List<Interview> allScreeningLast = filterInterviewsByType(lastConsiderationInterviews, SCREENING);
//            if (!allScreeningLast.isEmpty()) {
//                screeningMax.setValue(extractMaxGrade(allScreeningLast));
//                screeningMin.setValue(extractMinGrade(allScreeningLast));
//                screeningMedian.setValue(calculateMedian(allScreeningLast));
//            }
//            List<Interview> allRegularLast = filterInterviewsByType(lastConsiderationInterviews, REGULAR);
//            if (!allRegularLast.isEmpty()) {
//                regularMax.setValue(extractMaxGrade(allRegularLast));
//                regularMin.setValue(extractMinGrade(allRegularLast));
//                regularMedian.setValue(calculateMedian(allRegularLast));
//                lastRegularNoHire.setValue(calculateNoHire(allRegularLast));
//            } else {
//                lastRegularNoHire.setValue(NO_HIRE_FALSE);
//            }
//            List<Interview> allAALast = filterInterviewsByType(lastConsiderationInterviews, AA);
//            if (!allAALast.isEmpty()) {
//                aaMax.setValue(extractMaxGrade(allAALast));
//                aaMin.setValue(extractMinGrade(allAALast));
//                aaMedian.setValue(calculateMedian(allAALast));
//                lastAANoHire.setValue(calculateNoHire(allAALast));
//            } else {
//                lastAANoHire.setValue(NO_HIRE_FALSE);
//            }
//        } else {
//            lastRegularNoHire.setValue(NO_HIRE_FALSE);
//            lastAANoHire.setValue(NO_HIRE_FALSE);
//        }
//        return customFieldsStore;
//    }
//
//    /**
//     * Returns {@link CustomField} list of populated grades for all interviews.
//     */
//    private static List<CustomField> getAllInterviewGrades(List<Interview> interviews) {
//        var allScreeningMax = new CustomField(ALL_SCREENING_MAX, EMPTY_GRADE);
//        var allScreeningMin = new CustomField(ALL_SCREENING_MIN, EMPTY_GRADE);
//        var allScreeningMedian = new CustomField(ALL_SCREENING_MEDIAN, EMPTY_GRADE);
//        var allRegularMax = new CustomField(ALL_REGULAR_MAX, EMPTY_GRADE);
//        var allRegularMin = new CustomField(ALL_REGULAR_MIN, EMPTY_GRADE);
//        var allRegularMedian = new CustomField(ALL_REGULAR_MEDIAN, EMPTY_GRADE);
//        var allRegularNoHire = new CustomField(ALL_REGULAR_NO_HIRE, EMPTY_GRADE);
//        var allAAMax = new CustomField(ALL_AA_MAX, EMPTY_GRADE);
//        var allAAMin = new CustomField(ALL_AA_MIN, EMPTY_GRADE);
//        var allAAMedian = new CustomField(ALL_AA_MEDIAN, EMPTY_GRADE);
//        var allAANoHire = new CustomField(ALL_AA_NO_HIRE, EMPTY_GRADE);
//
//        List<CustomField> customFieldsStore = new ArrayList<>(List.of(allScreeningMax, allScreeningMin, allScreeningMedian,
//                allRegularMax, allRegularMin, allRegularMedian, allRegularNoHire, allAAMax, allAAMin, allAAMedian, allAANoHire));
//
//        List<Interview> allScreening = filterInterviewsByType(interviews, SCREENING);
//        if (!allScreening.isEmpty()) {
//            allScreeningMax.setValue(extractMaxGrade(allScreening));
//            allScreeningMin.setValue(extractMinGrade(allScreening));
//            allScreeningMedian.setValue(calculateMedian(allScreening));
//        }
//        List<Interview> allRegular = filterInterviewsByType(interviews, REGULAR);
//        if (!allRegular.isEmpty()) {
//            allRegularMax.setValue(extractMaxGrade(allRegular));
//            allRegularMin.setValue(extractMinGrade(allRegular));
//            allRegularMedian.setValue(calculateMedian(allRegular));
//            allRegularNoHire.setValue(calculateNoHire(allRegular));
//        } else {
//            allRegularNoHire.setValue(NO_HIRE_FALSE);
//        }
//        List<Interview> allAA = filterInterviewsByType(interviews, AA);
//        if (!allAA.isEmpty()) {
//            allAAMax.setValue(extractMaxGrade(allAA));
//            allAAMin.setValue(extractMinGrade(allAA));
//            allAAMedian.setValue(calculateMedian(allAA));
//            allAANoHire.setValue(calculateNoHire(allAA));
//        } else {
//            allAANoHire.setValue(NO_HIRE_FALSE);
//        }
//        return customFieldsStore;
//    }
//
//    /**
//     * Calculate median grade.
//     *
//     * @param interviews - source interviews to calculate
//     * @return median value as String
//     */
//    private static String calculateMedian(Collection<Interview> interviews) {
//        List<Integer> sortedGrades = interviews.stream()
//                .map(Interview::getGrade)
//                .filter(Objects::nonNull)
//                .sorted()
//                .collect(Collectors.toList());
//        if (sortedGrades.isEmpty()) {
//            return EMPTY_GRADE;
//        } else if (sortedGrades.size() == 1) {
//            return String.valueOf(sortedGrades.get(0));
//        } else if (sortedGrades.size() % 2 == 0) {
//            int left = sortedGrades.get(sortedGrades.size() / 2 - 1);
//            int right = sortedGrades.get(sortedGrades.size() / 2);
//            int sum = left + right;
//            if (sum % 2 == 0) {
//                return String.valueOf((left + right) / 2);
//            } else {
//                return String.valueOf((left + right) / 2 + 1);
//            }
//        } else {
//            return String.valueOf(sortedGrades.get(sortedGrades.size() / 2));
//        }
//    }
//
//    /**
//     * Filter interviews by type.
//     */
//    private static List<Interview> filterInterviewsByType(Collection<Interview> interviews, String type) {
//        return interviews == null ? Collections.emptyList() : interviews.stream()
//                .filter(interview -> type.equalsIgnoreCase(interview.getType()))
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * Extract max grade.
//     *
//     * @param interviews - source
//     * @return max grade.
//     */
//    private static String extractMaxGrade(Collection<Interview> interviews) {
//        return interviews.stream()
//                .map(Interview::getGrade)
//                .filter(Objects::nonNull)
//                .mapToInt(integer -> integer)
//                .max().stream()
//                .mapToObj(String::valueOf)
//                .findFirst()
//                .orElse(EMPTY_GRADE);
//    }
//
//    /**
//     * Extract min grade.
//     *
//     * @param interviews - source
//     * @return min grade.
//     */
//    private static String extractMinGrade(Collection<Interview> interviews) {
//        return interviews.stream()
//                .map(Interview::getGrade)
//                .filter(Objects::nonNull)
//                .mapToInt(integer -> integer)
//                .min().stream()
//                .mapToObj(String::valueOf)
//                .findFirst()
//                .orElse(EMPTY_GRADE);
//    }
//
//    /**
//     * Calculates NO_HIRE, true if exist at least one '0' grade
//     */
//    private String calculateNoHire(Collection<Interview> interviews) {
//        if (interviews.stream().map(Interview::getGrade).allMatch(Objects::isNull)) {
//            return EMPTY_GRADE;
//        }
//        return interviews.stream()
//                .map(Interview::getGrade)
//                .filter(Objects::nonNull)
//                .mapToInt(integer -> integer)
//                .anyMatch(grade -> grade == 0) ? NO_HIRE_TRUE : NO_HIRE_FALSE;
//    }
}
