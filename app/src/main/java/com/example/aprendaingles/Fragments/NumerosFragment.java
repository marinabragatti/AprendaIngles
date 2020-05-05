package com.example.aprendaingles.Fragments;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aprendaingles.R;


public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageView imageOne, imageTwo, imageThree, imageFour, imageFive, imageSix;

    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Nesta view consigo acessar qualquer componente do fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        //Permitir acesso aos componentes
        imageOne = view.findViewById(R.id.one);
        imageTwo = view.findViewById(R.id.two);
        imageThree = view.findViewById(R.id.three);
        imageFour = view.findViewById(R.id.four);
        imageFive = view.findViewById(R.id.five);
        imageSix = view.findViewById(R.id.six);

        //Aplica os eventos de click e trata todos de uma vez no método onClick abaixo
        imageOne.setOnClickListener(this); //utilizo o this para que a própria classe faça o tratamento (pois a interface onClickListener está implementada na classe NumerosFragment)
        imageTwo.setOnClickListener(this);
        imageThree.setOnClickListener(this);
        imageFour.setOnClickListener(this);
        imageFive.setOnClickListener(this);
        imageSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.one:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                tocarSom();
                break;

            case R.id.two:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSom();
                break;

            case R.id.three:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSom();
                break;

            case R.id.four:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSom();
                break;

            case R.id.five:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSom();
                break;

            case R.id.six:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                tocarSom();
                break;
        }
    }

    public void tocarSom(){
            if(mediaPlayer != null){
                mediaPlayer.start();

                //O método setOnCompletionListener permite add um evento quando o áudio terminar
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.release(); //método release libera os recursos utilizados
                    }
                });
            }
        }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
