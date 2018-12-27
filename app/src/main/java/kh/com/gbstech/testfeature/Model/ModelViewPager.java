package kh.com.gbstech.testfeature.Model;

import kh.com.gbstech.testfeature.R;

public enum  ModelViewPager {

        RED(R.string.red, R.layout.view_red),
        BLUE(R.string.blue, R.layout.view_blue),
        GREEN(R.string.green, R.layout.view_green),;


        private int mTitleResId;
        private int mLayoutResId;

        ModelViewPager(int titleResId, int layoutResId) {
            mTitleResId = titleResId;
            mLayoutResId = layoutResId;
        }

        public int getTitleResId() {
            return mTitleResId;
        }

        public int getLayoutResId() {
            return mLayoutResId;
        }

    }
