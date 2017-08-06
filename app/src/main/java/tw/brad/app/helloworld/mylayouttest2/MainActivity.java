package tw.brad.app.helloworld.mylayouttest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private String answer;
    private EditText inputEdit;
    private TextView logText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEdit = (EditText) findViewById(R.id.inputText);
        logText = (TextView)findViewById(R.id.logText);
        answer = createAnswer(3);
        Log.d("brad", "answer is " + answer);

    }

    // Create Answer
    private String createAnswer(int num){
        Set<Integer> set = new HashSet<>();
        while (set.size()<num){
            set.add((int)(Math.random()*10));
        }
        StringBuilder sb = new StringBuilder();
        for (Integer d : set){
            sb.append(d);
        }
        return sb.toString();
    }

    private String checkAB(String a, String g){
        int A, B; A = B = 0;
        for (int i=0; i<g.length(); i++){
            if (g.charAt(i) == a.charAt(i)){
                A++;
            }else if (a.indexOf(g.charAt(i))>=0){
                B++;
            }
        }
        return A + "A" + B + "B";
    }

    public void doGuess(View view){
        // TODO doGuess
        String guess = inputEdit.getText().toString();
        String result = checkAB(answer, guess);
        logText.append(guess + " : " + result + "\n");
        inputEdit.setText("");

    }
    public void doReset(View view){
        // TODO doReset
    }
    public void doSetting(View view){
        // TODO doSetting
    }
    public void doExit(View view){
        // TODO doExit
    }

}
