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
    private val maxNumberOfQuestion = 9
    lateinit var sharedPreferences: SharedPreferences

    var questions:ArrayList<Question> = arrayListOf(
        Question("Which is the Independence day of USA?",
            arrayListOf("26 March","21 Feb","14th April","16 December") ),
        Question("Who is the first man landed on moon?",
            arrayListOf("Neil Armstrong","Edwin Aldrin", "Michael Collins", "Yuri Gregory")),
        Question("Socrates is best known for - ",
            arrayListOf("Philosophy","Mathmetics","Physiology","Astrology")),
        Question("How many states does USA have? ",
            arrayListOf("50","45","55","49")),
        Question("Which is  an African Country? ",
            arrayListOf("Eritrea","Estonia","Lithunia","Moldova")),
        Question("Who is the first President of USA? ",
            arrayListOf("George Washington","William Henry Harrison","Abraham Lincoln","Franklin D. Roosevelt")),
        Question("Which one is the largest ocean? ",
            arrayListOf("Pacific","Atlantic","Mediterian","Arctic")),
        Question("What country has a town named Marathon? ",
            arrayListOf("USA","GREECE","ITALY","FRANCE")),
        Question("What is the Economic System of united states",
            arrayListOf("Capitalist","Socialist","Comunist","None")),
        Question("What country was formerly known as Ceylon?",
            arrayListOf("Sri Lanka","Sweden","Vietnam","Switzerland"))
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

        sharedPreferences = activity!!.getSharedPreferences("SP_HIGH_SCORE", MODE_PRIVATE)

    }

    private fun checkAnswer(answer:String) {
        if (answer.equals(currentQuestion.answerGroup[0])) {
            score += 1



        } else {
            score2+=1

        }
        allscore= score + score2
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
