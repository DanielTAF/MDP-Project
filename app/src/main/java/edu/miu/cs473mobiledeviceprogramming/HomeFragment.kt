package edu.miu.cs473mobiledeviceprogramming
import android.content.Intent
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

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (NavigationUI.onNavDestinationSelected(item, view!!.findNavController())) {
            return true
        } else {

            return super.onOptionsItemSelected(item)

        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }




}

