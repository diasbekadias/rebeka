package rebeka.queyla.email;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import android.content.ActivityNotFoundException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Encontra o botão pelo ID definido no layout XML
        Button btnEnviar =(Button) findViewById(R.id.btnEnviar);



        // Define um OnClickListener para o botão
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // O código a ser executado quando o botão é clicado
                // Aqui você pode colocar o código para enviar o email
                // Obtendo dados digitados pelo usuario
                EditText etEmail = (EditText)  findViewById(R.id.etEmail);
                String email = etEmail.getText().toString();

                EditText etAssunto = (EditText)  findViewById(R.id.etAssunto);
                String assunto = etEmail.getText().toString();

                EditText etTexto = (EditText)  findViewById(R.id.etTexto);
                String texto = etEmail.getText().toString();

                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));

                String[] emails = new String[]{email};
                i.putExtra(Intent.EXTRA_EMAIL, emails);
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                i.putExtra(Intent.EXTRA_TEXT, texto);

                try {
                    startActivity(Intent.createChooser(i, "Escolha o APP"));

                }

                catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nenhum  app que posso realizar essa operação",  Toast.LENGTH_LONG).show();

                }

                }



        });
    }
}

