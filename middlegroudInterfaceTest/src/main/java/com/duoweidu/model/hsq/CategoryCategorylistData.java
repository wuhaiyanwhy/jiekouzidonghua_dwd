package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class CategoryCategorylistData {

    public ArrayList<ListModel> list;

    public static class ListModel {

        public int id;
        public String name;
        public String thumbnail;
        public ArrayList<SubCategoriesModel> subCategories;

        public static class SubCategoriesModel {
            public int id;
            public String name;
            public String thumbnail;
        }

    }
}
