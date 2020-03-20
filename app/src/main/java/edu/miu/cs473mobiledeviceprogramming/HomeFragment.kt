package edu.miu.cs473mobiledeviceprogramming
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import edu.miu.cs473mobiledeviceprogramming.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
   // val user = FirebaseAuth.getInstance().currentUser
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
//        binding.btnPlay.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_quizFragment3)
//        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(NavigationUI.onNavDestinationSelected(item,view!!.findNavController())){
            return true
        }
        return super.onOptionsItemSelected(item)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        if(user==null){
//            Navigation.findNavController(view!!).navigate(R.id.action_titleFragment_to_mainFragment)
//        }
    }




}

