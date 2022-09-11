package io.github.lkodex.ocuradordasareias.ui.quotes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import io.github.lkodex.ocuradordasareias.MainActivity;
import io.github.lkodex.ocuradordasareias.R;
import io.github.lkodex.ocuradordasareias.databinding.FragmentQuotesBinding;
import io.github.lkodex.ocuradordasareias.ui.skins.SkinsFragment;

public class QuotesFragment extends Fragment {
    private MediaPlayer mediaPlayer;
    private FragmentQuotesBinding binding;
    private Boolean isSaul = false;

    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentQuotesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.champion_audio_description,
                android.R.layout.simple_spinner_item
        );

        binding.spinnerNasusQuotes.setAdapter(adapter);

        binding.spinnerNasusQuotes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (binding.switchAutoplay.isChecked()) playMediaPlayer(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { /* Does nothing */ }
        });

        binding.btnAudioplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playMediaPlayer(binding.spinnerNasusQuotes.getSelectedItemPosition());
            }
        });

        return root;
    }

    public void onStop(){
        super.onStop();
        if (mediaPlayer != null) mediaPlayer.release();
        MainActivity.mainContainer.setBackgroundResource(SkinsFragment.selectedItemId);
        binding.switchAutoplay.setChecked(false);
    }

    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }

    private void playMediaPlayer(Integer spinnerPosition){
        Integer rawSongId;
        switch (spinnerPosition){
            case 0:
                rawSongId = R.raw.nasus_joke_0;
                break;
            case 1:
                rawSongId = R.raw.nasus_joke_1;
                break;
            case 2:
                rawSongId = R.raw.nasus_joke_2;
                break;
            case 3:
                rawSongId = R.raw.nasus_taunt_0;
                break;
            case 4:
                rawSongId = R.raw.nasus_taunt_1;
                break;
            case 5:
                rawSongId = R.raw.nasus_laugh_0;
                break;
            case 6:
                rawSongId = R.raw.nasus_laugh_1;
                break;
            case 7:
                rawSongId = R.raw.nasus_laugh_2;
                break;
            case 8:
                rawSongId = R.raw.nasus_laugh_3;
                break;
            case 9:
                rawSongId = R.raw.nasus_laugh_4;
                break;
            default:
                rawSongId = R.raw.saul_goodman_be_warned;
        }

        tocarMusica(rawSongId);
    }


    private void tocarMusica(Integer rawSongId){
        if (isSaul && rawSongId != R.raw.saul_goodman_be_warned)
            MainActivity.mainContainer.setBackgroundResource(SkinsFragment.selectedItemId);
        if (mediaPlayer != null)
            mediaPlayer.release();
        mediaPlayer = MediaPlayer.create(getContext(), rawSongId);

        isSaul = rawSongId == R.raw.saul_goodman_be_warned;
        if (isSaul) {
            MainActivity.mainContainer.setBackgroundResource(R.drawable.saul_goodman);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                    MainActivity.mainContainer.setBackgroundResource(SkinsFragment.selectedItemId);
                }
            });
        }
        else {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
        mediaPlayer.start();
    }
}
