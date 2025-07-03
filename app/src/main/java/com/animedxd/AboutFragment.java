package com.animedxd;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView greetingText;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // HANYA inflate sekali
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        // Temukan ImageView dan ubah warnanya
        ImageView imageView = view.findViewById(R.id.imageView4);
        imageView.setColorFilter(Color.parseColor("#292929"));

        ImageView backgroundImage = view.findViewById(R.id.background);
        backgroundImage.setColorFilter(Color.parseColor("#F2F1F2"));

        // ✅ Tambahkan Greeting berdasarkan SharedPreferences
        greetingText = view.findViewById(R.id.greetingText);
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", requireContext().MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "User");
        greetingText.setText("Welcome, " + username);

        EditText messageInput = view.findViewById(R.id.messageInput);
        messageInput.setMovementMethod(new android.text.method.ScrollingMovementMethod());

        EditText nameInput = view.findViewById(R.id.nameInput);
        EditText emailInput = view.findViewById(R.id.emailInput);
        Button submitButton = view.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            nameInput.setText("");
            emailInput.setText("");
            messageInput.setText("");

            messageInput.clearFocus();   // biar hint langsung muncul
//            messageInput.requestLayout();
//            messageInput.invalidate();
        });


        // return view yang sudah dimodifikasi
        return view;
    }

}