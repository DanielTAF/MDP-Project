package edu.miu.cs473mobiledeviceprogramming
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import edu.miu.cs473mobiledeviceprogramming.databinding.FragmentQuizBinding

import kotlinx.android.synthetic.main.fragment_quiz.*


/**
 * A simple [Fragment] subclass.
 */
class Quiz : Fragment() {
    lateinit var binding: FragmentQuizBinding
    lateinit var currentQuestion:Question
    private var questionIndex = 0
    private val maxNumberOfQuestion = 15
    lateinit var sharedPreferences: SharedPreferences

    var questions:ArrayList<Question> = arrayListOf(
        Question("Kotlin is developed by?",
            arrayListOf("jetBrains","Google","Oracle","Adobe") ),
        Question("Which of the following is used to handle null exceptions in Kotlin?",
            arrayListOf("Elvis operator","Range", "Sealed Class", "Lambda function")),
        Question("How do you get the lengh of Kotlin? ",
            arrayListOf("str.length","length(str)","str.lenghtOf"," str.size")),
        Question("Can a class be immutable in android? ",
            arrayListOf("Yes,class can be immutable","No,it can't","can'tmake the class as final class","None of the above")),
        Question("What are the JSON elements in android? ",
            arrayListOf("Number,String,boolean, null and object","Boolean","Ineger boolean","null")),
        Question("How many ports are allocated for new emulator? ",
            arrayListOf("2","0","10","Non of the above")),
        Question("How to store heavy structured data in android? ",
            arrayListOf("shared Preference","Cursor","Sqlite database","Not possible")),
        Question(" What are the layouts available in android? ",
            arrayListOf("Linear Layout","Frame Layout","Table Layout","Relative Layout")),
        Question("Once installed on a device, each Android application lives in_______?",
            arrayListOf("Security sandbox","device memory","external memory","None")),
        Question("Parent class of Activity?",
            arrayListOf("activityGroup","object","context","ContexThameWrapper")),

                Question("What are the Direct subclasses of Activity?",
        arrayListOf("activityGroup","object","context","ContexThameWrapper")),

        Question("What are the Direct subclasses of Activity?",
            arrayListOf("All","ListActivity","FragmentActivity","ActivityGroup")),


        Question("Which component is not activated by an Intent?",
            arrayListOf("contentProvider","activity","service","BroadcastReceiver")),


        Question("Which are the  screen densities in Android?",

            arrayListOf("All","low density","extra high density","medium density")),

        Question("Which one is NOT related to fragment class?",
            arrayListOf("cursor Fragment","dialogFragment","preferenceFragment","listFragment")),

        Question("How many ways to start services?",
            arrayListOf("started & bound","stated ","bound ","messenger"))
    )



    lateinit var answers:ArrayList<String>

    var score:Int = 0
    var score2:Int=0
    var allscore:Int=0

    var wrongAnswerList:ArrayList<String> = ArrayList()
    var resultList:ArrayList<String> = ArrayList()
    private fun setQuestion(){
        currentQuestion = questions[questionIndex]
        answers = ArrayList(currentQuestion.answerGroup)
        answers.shuffle()

        Log.d("ANSWERGROUP", answers[0]+ " "+answers[1]+ " "+answers[2]+ " "+answers[3]+ " ")
        Log.d("REALANSWER", currentQuestion.answerGroup[0])



    }

    private fun randomQuestion(){
        questions.shuffle()
        setQuestion()
    }





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quiz,container,false)
        binding.btnhome.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_quiz_to_home)
        }
        randomQuestion()
        binding.quiz=this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        option1.setOnClickListener{
            checkAnswer(option1.text.toString())

        }
        option2.setOnClickListener{
            checkAnswer(option2.text.toString())

        }
        option3.setOnClickListener{
            checkAnswer(option3.text.toString())

        }
        option4.setOnClickListener{
            checkAnswer(option4.text.toString())

        }



    }

    private fun checkAnswer(answer:String) {
        if (answer.equals(currentQuestion.answerGroup[0])) {
            score += 1
        }

        resultList.add(currentQuestion.theQuestion)
        resultList.add(currentQuestion.answerGroup[0])

        next.setOnClickListener{
            clear()
            questionIndex++
            if (questionIndex <= maxNumberOfQuestion) {
                setQuestion()
                binding.invalidateAll()
            } else {
                getScore()
            }
        }
    }




    fun clear() {

        option1.isChecked = false
        option2.isChecked = false
        option3.isChecked = false
        option4.isChecked = false
    }

    private fun getScore(){

            val action = QuizDirections.actionQuizToQuizresult(score,wrongAnswerList.toTypedArray())
            view!!.findNavController().navigate(action)
    }
}
