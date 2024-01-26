package com.liveedu.currencyconverteredu.utils;

//import com.epam.beamery.model.Consideration;
//import com.epam.beamery.model.Interview;
//import com.epam.beamery.model.Note;
//import com.epam.beamery.model.NoteType;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Builds pinned note with consideration information.
 */
@UtilityClass
public class ConsiderationsNoteBuilder {

    private static final Logger log = LoggerFactory.getLogger(ConsiderationsNoteBuilder.class);

    private static final String HEADER_DATE_FORMAT = "yyyy.MM.dd";
    private static final String NEXT_LINE = "<br>";
    private static final String NOW_CONSIDERATION_DATE = "now";
    private static final String HEADER_TEMPLATE = "%s - %s";
    private static final String GRADES_SEPARATOR = ", ";

    private static final String SCREENING_INTERVIEW_TYPE = "screening";
    private static final String REGULAR_INTERVIEW_TYPE = "regular";
    private static final String AA_INTERVIEW_TYPE = "aa";
    private static final String FINAL_INTERVIEW_TYPE = "final";
    private static final String HR_SCREENING_INTERVIEW_TYPE = "hr_screening";

    private static final String SCREENING_INTERVIEW_TYPE_TITLE = "- Screening : ";
    private static final String REGULAR_INTERVIEW_TYPE_TITLE = "- Regular : ";
    private static final String AA_INTERVIEW_TYPE_TITLE = "- AA : ";
    private static final String FINAL_INTERVIEW_TYPE_TITLE = "- Final : ";
    private static final String HR_SCREENING_INTERVIEW_TYPE_TITLE = "- HR screening : ";
    private static final String CONSIDERATION_RESOLUTION_TITLE = "- Resolution : ";
    private static final String CONSIDERATION_SOURCE_TITLE = "- Source : ";

//    public Note buildNote(List<Consideration> considerations, List<Interview> interviews, Long candidateId, String modified) {
//        List<Pair<Consideration, List<Interview>>> considerationToInterviews = mapConsiderationToInterviews(considerations, interviews);
//        String noteText = buildAndConcatenateEachNoteText(considerationToInterviews);
//
//        return Note.builder()
//                .text(noteText)
//                .modified(modified)
//                .candidateId(candidateId)
//                .noteType(NoteType.CONSIDERATION)
//                .build();
//    }

//    private String buildAndConcatenateEachNoteText(List<Pair<Consideration, List<Interview>>> considerationInterviewsPairList) {
//        return considerationInterviewsPairList.stream()
//                .map(ConsiderationsNoteBuilder::buildNote)
//                .collect(Collectors.joining(NEXT_LINE + NEXT_LINE));
//    }
//
//    private List<Pair<Consideration, List<Interview>>> mapConsiderationToInterviews(List<Consideration> considerations, List<Interview> interviews) {
//        return considerations.stream()
//                .map(consideration -> Pair.of(consideration, getInterviewsByConsiderationId(consideration.getId(), interviews)))
//                .sorted(Comparator.comparing(entry -> entry.getFirst().getCreated(), Comparator.reverseOrder()))
//                .collect(Collectors.toList());
//    }
//
//    private List<Interview> getInterviewsByConsiderationId(long considerationId, List<Interview> interviews) {
//        return interviews == null || interviews.isEmpty() ? Collections.emptyList() :
//                interviews.stream().filter(interview -> interview.getConsiderationId() == considerationId).collect(Collectors.toList());
//    }
//
//    private String buildNote(Pair<Consideration, List<Interview>> entry) {
//        List<String> result = new ArrayList<>();
//        Consideration consideration = entry.getFirst();
//        List<Interview> interviews = entry.getSecond();
//        appendHeader(consideration, result);
//        appendGrades(interviews, result);
//        appendResolutionAndSource(consideration, result);
//        return String.join(NEXT_LINE, result);
//    }
//
//    private void appendResolutionAndSource(Consideration consideration, List<String> result) {
//        appendIfNotEmpty(result, CONSIDERATION_RESOLUTION_TITLE, consideration.getResolution());
//        appendIfNotEmpty(result, CONSIDERATION_SOURCE_TITLE, consideration.getSource());
//    }
//
//    private void appendGrades(List<Interview> interviews, List<String> result) {
//        appendIfNotEmpty(result, SCREENING_INTERVIEW_TYPE_TITLE, collectGradesByType(interviews, SCREENING_INTERVIEW_TYPE));
//        appendIfNotEmpty(result, REGULAR_INTERVIEW_TYPE_TITLE, collectGradesByType(interviews, REGULAR_INTERVIEW_TYPE));
//        appendIfNotEmpty(result, AA_INTERVIEW_TYPE_TITLE, collectGradesByType(interviews, AA_INTERVIEW_TYPE));
//        appendIfNotEmpty(result, FINAL_INTERVIEW_TYPE_TITLE, collectGradesByType(interviews, FINAL_INTERVIEW_TYPE));
//        appendIfNotEmpty(result, HR_SCREENING_INTERVIEW_TYPE_TITLE, collectGradesByType(interviews, HR_SCREENING_INTERVIEW_TYPE));
//    }
//
//    private void appendHeader(Consideration consideration, List<String> result) {
//        result.add(String.format(HEADER_TEMPLATE,
//                formatDate(consideration.getCreated()),
//                consideration.getFinished() == null ? NOW_CONSIDERATION_DATE : formatDate(consideration.getFinished())));
//    }
//
//    private void appendIfNotEmpty(List<String> note, String left, String right) {
//        if (right != null && !right.isEmpty()) {
//            note.add(left + right);
//        }
//    }
//
//    private String formatDate(OffsetDateTime offsetDateTime) {
//        return offsetDateTime.format(DateTimeFormatter.ofPattern(HEADER_DATE_FORMAT));
//    }
//
//    private String collectGradesByType(List<Interview> interviews, String type) {
//        log.trace("ConsiderationsNoteBuilder#collectGradesByType - start: interviews = {}, type = {}", interviews, type);
//        List<Interview> filteredInterviews = interviews == null ? Collections.emptyList() : interviews.stream()
//                .filter(interview -> type.equalsIgnoreCase(interview.getType()))
//                .collect(Collectors.toList());
//
//        return filteredInterviews.stream()
//                .filter(Objects::nonNull)
//                .sorted(Comparator.nullsFirst(Comparator.comparing(Interview::getFinished, Comparator.nullsFirst(Comparator.reverseOrder()))))
//                .map(Interview::getGrade)
//                .filter(Objects::nonNull)
//                .map(String::valueOf)
//                .collect(Collectors.joining(GRADES_SEPARATOR));
//    }
}
