package com.liveedu.currencyconverteredu.utils;

//import com.epam.beamery.dto.CandidateDTO;
//import com.epam.beamery.dto.CustomField;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class DTOEqualsUtils {

    //Comparison order is important! Highest rows change more frequently than lower ones
//    public static boolean dtoEquals(CandidateDTO thiz, CandidateDTO that) {
//        return thiz.isConfidential() == that.isConfidential() &&
//                Objects.equals(thiz.getGlobalStatusDTO(), that.getGlobalStatusDTO()) &&
//                Objects.equals(thiz.getLocation(), that.getLocation()) &&
//                Objects.equals(thiz.getLastName(), that.getLastName()) &&
//                Objects.equals(thiz.getFirstName(), that.getFirstName()) &&
//                Objects.equals(thiz.getSource(), that.getSource()) &&
//                Objects.equals(thiz.getAssignedTo(), that.getAssignedTo()) &&
//                isCustomFieldCollectionsEquals(thiz.getCustomFields(), that.getCustomFields()) &&
//                isStringCollectionsEquals(thiz.getTags(), that.getTags()) &&
//                isStringCollectionsEquals(thiz.getEmails(), that.getEmails()) &&
//                isStringCollectionsEquals(thiz.getLinks(), that.getLinks()) &&
//                isStringCollectionsEquals(thiz.getPhoneNumbers(), that.getPhoneNumbers()) &&
//                isStringCollectionsEquals(thiz.getSkills(), that.getSkills()) &&
//                isCollectionsEquals(thiz.getExperience(), that.getExperience()) &&
//                isCollectionsEquals(thiz.getEducation(), that.getEducation()) &&
//                isStringCollectionsEquals(thiz.getMiddleNames(), that.getMiddleNames());
//    }
//
//    public static boolean customFieldEquals(CustomField thiz, CustomField that) {
//        return Objects.equals(thiz.getDisplayName(), that.getDisplayName())
//                && Objects.equals(thiz.getValue(), that.getValue())
//                && isStringCollectionsEquals(thiz.getValues(), that.getValues());
//    }
//
//    private static <T> boolean isCollectionsEquals(Collection<T> thisCollection, Collection<T> otherCollection) {
//        return thisCollection == null
//                ? otherCollection == null
//                : otherCollection != null
//                && thisCollection.size() == otherCollection.size()
//                && thisCollection.containsAll(otherCollection);
//    }
//
//    public static boolean isStringCollectionsEquals(Collection<String> thisCollection, Collection<String> otherCollection) {
//        return thisCollection == null
//                ? otherCollection == null
//                : otherCollection != null
//                && thisCollection.size() == otherCollection.size()
//                && sortStringCollection(thisCollection).equals(sortStringCollection(otherCollection));
//    }
//
//    private static List<String> sortStringCollection(Collection<String> collection) {
//        var result = new ArrayList<>(collection);
//        result.sort(Comparator.naturalOrder());
//        return result;
//    }
//
//    private static boolean isCustomFieldCollectionsEquals(Collection<CustomField> thisCollection, Collection<CustomField> otherCollection) {
//        return thisCollection == null
//                ? otherCollection == null
//                : otherCollection != null
//                && thisCollection.size() == otherCollection.size()
//                && sortCustomFieldCollection(thisCollection).equals(sortCustomFieldCollection(otherCollection));
//    }
//
//    private static List<CustomField> sortCustomFieldCollection(Collection<CustomField> collection) {
//        var result = new ArrayList<>(collection);
//        result.sort(Comparator.comparing(CustomField::getDisplayName, Comparator.naturalOrder()));
//        return result;
//    }
}
