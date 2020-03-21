package edu.miu.cs473mobiledeviceprogramming

//import com.example.simplequiz.databinding.FragmentCorrectAnswerBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

import edu.miu.cs473mobiledeviceprogramming.databinding.FragmentQuizResultBinding

/**
 * A simple [Fragment] subclass.
 */
class QuizResult : Fragment() {

    lateinit var binding: FragmentQuizResultBinding
    var add:String=""
    var loss:String=""
    var earnedScore: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_result, container, false)
        binding.btnTryAgain.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_quizresult_to_home)
        }
        binding.quizlost = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            val args = QuizResultArgs.fromBundle(it)
            var k= 15- args.score



            var add2= k.toString()
            earnedScore = args.score.toString()
            add="Correct answers: $earnedScore"
            loss="Incorect Answers: $add2 "

        }
    }

}
