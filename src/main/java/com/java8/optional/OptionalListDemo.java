package com.java8.optional;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalListDemo {

    public static void main(String[] args) {
        new OptionalListDemo().optionalList();
    }

    public void optionalList() {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add(null);
        list.add("xyz");
        Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream().filter(StringUtils::isNotBlank).forEach(System.out::println);

        //作用类似以下代码
//        if (CollectionUtils.isNotEmpty(list)) {
//            for (String str : list) {
//                if (StringUtils.isNotBlank(str)) {
//                    System.out.println(str);
//                }
//            }
//        }

    }


}
