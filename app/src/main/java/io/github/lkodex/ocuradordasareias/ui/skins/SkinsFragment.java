package io.github.lkodex.ocuradordasareias.ui.skins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import io.github.lkodex.ocuradordasareias.MainActivity;
import io.github.lkodex.ocuradordasareias.R;
import io.github.lkodex.ocuradordasareias.databinding.FragmentSkinsBinding;

public class SkinsFragment extends Fragment {
    private FragmentSkinsBinding binding = null;
    public static Integer selectedItemId = R.drawable.ic_nasus_0;

    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ){
        binding = FragmentSkinsBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Integer> skinsId = new ArrayList<>();
        skinsId.add(R.drawable.ic_nasus_0);
        skinsId.add(R.drawable.ic_nasus_1);
        skinsId.add(R.drawable.ic_nasus_2);
        skinsId.add(R.drawable.ic_nasus_3);
        skinsId.add(R.drawable.ic_nasus_4);
        skinsId.add(R.drawable.ic_nasus_5);
        skinsId.add(R.drawable.ic_nasus_6);
        skinsId.add(R.drawable.ic_nasus_10);
        skinsId.add(R.drawable.ic_nasus_11);
        skinsId.add(R.drawable.ic_nasus_16);
        skinsId.add(R.drawable.ic_nasus_25);
        skinsId.add(R.drawable.ic_nasus_35);

        binding.gridView.setAdapter(new SkinsAdapter(getContext(), skinsId));
        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View parent, int position, long id) {
                switch (position){
                    case 1:
                        selectedItemId = R.drawable.loading_nasus_1;
                        break;
                    case 2:
                        selectedItemId = R.drawable.loading_nasus_2;
                        break;
                    case 3:
                        selectedItemId = R.drawable.loading_nasus_3;
                        break;
                    case 4:
                        selectedItemId = R.drawable.loading_nasus_4;
                        break;
                    case 5:
                        selectedItemId = R.drawable.loading_nasus_5;
                        break;
                    case 6:
                        selectedItemId = R.drawable.loading_nasus_6;
                        break;
                    case 7:
                        selectedItemId = R.drawable.loading_nasus_10;
                        break;
                    case 8:
                        selectedItemId = R.drawable.loading_nasus_11;
                        break;
                    case 9:
                        selectedItemId = R.drawable.loading_nasus_16;
                        break;
                    case 10:
                        selectedItemId = R.drawable.loading_nasus_25;
                        break;
                    case 11:
                        selectedItemId = R.drawable.loading_nasus_35;
                        break;
                    default:
                        selectedItemId = R.drawable.loading_nasus_0;
                }

                String nasusSkinName;
                switch (position) {
                    case 1:
                        nasusSkinName = "Nasus Galáctico";
                        break;
                    case 2:
                        nasusSkinName = "Nasus Faraônico";
                        break;
                    case 3:
                        nasusSkinName = "Nasus Cavaleiro do Terror";
                        break;
                    case 4:
                        nasusSkinName = "Riot Nasus K-9";
                        break;
                    case 5:
                        nasusSkinName = "Nasus Infernal";
                        break;
                    case 6:
                        nasusSkinName = "Nasus Arquiduque";
                        break;
                    case 7:
                        nasusSkinName = "Nasus Quebra-mundos";
                        break;
                    case 8:
                        nasusSkinName = "Nasus Guardião Lunar";
                        break;
                    case 9:
                        nasusSkinName = "Nasus Máquina de Combate";
                        break;
                    case 10:
                        nasusSkinName = "Nasus Embalos no Espaço";
                        break;
                    case 11:
                        nasusSkinName = "Nasus Titã Blindado";
                        break;
                    default:
                        nasusSkinName = "Nasus";
                }

                binding.txtSkinName.setText(nasusSkinName);
            }
        });

        binding.btnUpdateskin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainContainer.setBackgroundResource(selectedItemId);
            }
        });
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
