package pe.edu.idat.ec03_androidstudio

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.idat.ec03_androidstudio.R
import pe.edu.idat.ec03_androidstudio.databinding.FragmentFormularioBinding
import java.util.*

c
lass FormularioFragment : Fragment() {

    private var _binding: FragmentFormularioBinding? = null
    private val binding get() = _binding!!

    private val calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormularioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etFechaEntrada.setOnClickListener {
            showDatePicker(binding.etFechaEntrada)
        }

        binding.etFechaSalida.setOnClickListener {
            showDatePicker(binding.etFechaSalida)
        }

        binding.button.setOnClickListener {
            val numPerros = binding.etNumerodePerros.text.toString()
            showToast("Número de perros: $numPerros")
        }
    }

    private fun showDatePicker(editText: EditText) {
        val dateSetListener = DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val dateString = "${dayOfMonth}/${month + 1}/$year"
            editText.setText(dateString)
        }

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            dateSetListener,
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
