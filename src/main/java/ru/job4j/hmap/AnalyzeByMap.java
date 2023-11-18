package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int scores = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scores += subject.score();
                count++;
            }
        }
        return (double) scores / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int scores = 0;
            for (Subject subject : pupil.subjects()) {
                scores += subject.score();
            }
            result.add(new Label(pupil.name(), (double) scores / pupil.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> subjectsMap = getSubjectsMapFromPupilsList(pupils);
        for (Map.Entry<String, Integer> entry : subjectsMap.entrySet()) {
            result.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int scores = 0;
            for (Subject subject : pupil.subjects()) {
                scores += subject.score();
            }
            list.add(new Label(pupil.name(), scores));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> subjectsMap = getSubjectsMapFromPupilsList(pupils);
        for (Map.Entry<String, Integer> entry : subjectsMap.entrySet()) {
            list.add(new Label(entry.getKey(), entry.getValue()));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    private static Map<String, Integer> getSubjectsMapFromPupilsList(List<Pupil> pupils) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                result.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        return result;
    }
}