package pe.edu.idat.ec03_androidstudio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListaReservasFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var reservasAdapter: ReservasAdapter
    private val reservasList = mutableListOf<Reserva>() // Lista de reservas

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_lista_reservas, container, false)
        listView = rootView.findViewById(R.id.lvReservaciones)
        reservasAdapter = ReservasAdapter(requireContext(), reservasList)
        listView.adapter = reservasAdapter
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recibir los datos del formulario del Bundle
        val numPerros = arguments?.getString("numPerros")
        val servicio = arguments?.getString("servicio")
        val fechaEntrada = arguments?.getString("fechaEntrada")
        val fechaSalida = arguments?.getString("fechaSalida")

        // Crear un objeto Reserva con los datos del formulario
        val reserva = Reserva(numPerros, servicio, fechaEntrada, fechaSalida)

        // Agregar la reserva a la lista de reservas
        reservasList.add(reserva)

        // Notificar al adaptador que los datos han cambiado
        reservasAdapter.notifyDataSetChanged()
    }
}
