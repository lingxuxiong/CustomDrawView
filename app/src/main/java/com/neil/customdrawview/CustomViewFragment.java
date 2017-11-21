package com.neil.customdrawview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Administrator on 2017/11/19 0019.
 */

public class CustomViewFragment extends Fragment {

    public static final String KEY_LABEL = "label";
    private String mLabel;

    public String getLabel() {
        return mLabel;
    }

    public static CustomViewFragment newInstance(String label) {
        Bundle args = new Bundle();
        args.putString(KEY_LABEL, label);
        CustomViewFragment fragment = new CustomViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mLabel = args.getString(KEY_LABEL);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            String clsName = getContext().getPackageName() + ".views." + mLabel;
            Class cls = Class.forName(clsName);
            Constructor<? extends View> constructor = cls.getConstructor(Context.class);
            return constructor.newInstance(getContext());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
