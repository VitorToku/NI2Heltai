package br.edu.estudofecap.ni2heltai;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgPizza, rgPorcao, rgBebida;
    RadioButton rbFrango, rbCalabresa, rbQueijo, rbFritas, rbMandioca, rbPolenta, rbGuarana, rbCoca, rbFanta;
    String pizza, porcao, bebida, bordaRecheada;
    EditText observacao, nomeCliente;
    ProgressBar pbPedido;
    TextView txtPedido;
    int pedido = 1830;
    Switch borda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        definirLinteners();
        txtPedido = findViewById(R.id.txtNumeroPedido);
        nomeCliente = findViewById(R.id.inputNome);
        pbPedido = findViewById(R.id.pbPedido);

        borda = findViewById(R.id.swcBordaRecheada);
        observacao = findViewById(R.id.inputObs);
        resetar();
    }

    public void definirLinteners(){
        rgPizza = findViewById(R.id.rgPizza);
        rgPorcao = findViewById(R.id.rgPorcoes);
        rgBebida = findViewById(R.id.rgBebida);

        rbFrango = findViewById(R.id.rbFrango);
        rbCalabresa = findViewById(R.id.rbCalabresa);
        rbQueijo = findViewById(R.id.rbQueijo);

        rbFritas = findViewById(R.id.rbFritas);
        rbMandioca = findViewById(R.id.rbMandioca);
        rbPolenta = findViewById(R.id.rbPolenta);

        rbGuarana = findViewById(R.id.rbGuarana);
        rbCoca = findViewById(R.id.rbCoca);
        rbFanta = findViewById(R.id.rbFanta);

        rgPizza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {//
                RadioButton radio = group.findViewById(checkedId);
                pizza = radio.getText().toString();
                Toast.makeText(MainActivity.this, "Selecionado: "+ pizza, Toast.LENGTH_SHORT).show();
            }
        });

        rgPorcao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {//
                RadioButton radio = group.findViewById(checkedId);
                porcao = radio.getText().toString();
                Toast.makeText(MainActivity.this, "Selecionado: "+ porcao, Toast.LENGTH_SHORT).show();
            }
        });

        rgBebida.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {//
                RadioButton radio = group.findViewById(checkedId);
                bebida = radio.getText().toString();
                Toast.makeText(MainActivity.this, "Selecionado: "+ bebida, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void finalizarPedido(View view){
        if(borda.isChecked()){
            bordaRecheada = "Sim";
        }
        AlertDialog.Builder confirmacao = new AlertDialog.Builder(this);
        confirmacao.setTitle("Confirmar pedido");
        confirmacao.setMessage("Seu pedido:\n" +
                "Cliente: " + nomeCliente.getText() +"\n"+
                "Pizza: " + pizza + "\n" +
                "Borda recheada: " + bordaRecheada + "\n"+
                "Poção: " + porcao + "\n" +
                "Bebida: " + bebida +"\n" +
                "Observações: " + observacao.getText());
        confirmacao.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Pedido confirmado", Toast.LENGTH_SHORT).show();
                pedido++;
                resetar();

            }
        });
        confirmacao.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        confirmacao.create();
        confirmacao.show();
    }
    public void resetar(){
        pizza = "Não selecionado";
        porcao = "Não selecionado";
        bebida = "Não selecionado";
        bordaRecheada = "Não";

        rbFrango.setChecked(false);
        rbCalabresa.setChecked(false);
        rbQueijo.setChecked(false);
        rbFritas.setChecked(false);
        rbMandioca.setChecked(false);
        rbPolenta.setChecked(false);
        rbGuarana.setChecked(false);
        rbCoca.setChecked(false);
        rbFanta.setChecked(false)  ;
        borda.setChecked(false);

        observacao.setText("");
        nomeCliente.setText("");
        txtPedido.setText("Nº do pedido: "+ pedido);
    }
}