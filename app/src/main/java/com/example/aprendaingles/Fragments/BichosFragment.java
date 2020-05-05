package com.example.aprendaingles.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aprendaingles.R;

//Interface OnCLickListener permite que se trate todos os eventos de clique em um único método

public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageView imageDog, imageCat, imageLion, imageMonkey, imageSheep, imageCow;

    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Nesta view consigo acessar qualquer componente do fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        //Permitir acesso aos componentes
        imageDog = view.findViewById(R.id.dog);
        imageCat = view.findViewById(R.id.cat);
        imageLion = view.findViewById(R.id.lion);
        imageMonkey = view.findViewById(R.id.monkey);
        imageSheep = view.findViewById(R.id.sheep);
        imageCow = view.findViewById(R.id.cow);

        //Aplica os eventos de click e trata todos de uma vez no método onClick abaixo
        imageDog.setOnClickListener(this); //utilizo o this para que a própria classe faça o tratamento (pois a interface onClickListener está implementada na classe BichosFragment)
        imageCat.setOnClickListener(this);
        imageLion.setOnClickListener(this);
        imageMonkey.setOnClickListener(this);
        imageSheep.setOnClickListener(this);
        imageCow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch ( view.getId() ) {
            case R.id.dog:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
                break;

            case R.id.cat:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;

            case R.id.lion:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;

            case R.id.monkey:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;

            case R.id.sheep:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;

            case R.id.cow:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
        }
    }

    public void tocarSom(){
        if (mediaPlayer != null){
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

    @Override //o que acontece quando o fragment for destruído
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release(); //Liberar o espaço de mémoria dos recursos utilizados para tocar o som
            mediaPlayer = null; //Liberar os recursos de memória do mediaPlayer
        }
    }
}
