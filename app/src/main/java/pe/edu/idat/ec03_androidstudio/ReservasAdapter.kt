package pe.edu.idat.ec03_androidstudio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ReservasAdapter(context: Context, data: List<Reserva>) : ArrayAdapter<Reserva>(context, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_reserva, parent, false)
        }

        val reserva = getItem(position)

        val textViewNumPerros = itemView!!.findViewById<TextView>(R.id.textViewNumPerros)
        textViewNumPerros.text = "Número de perros: ${reserva?.numPerros}"

        val textViewServicio = itemView.findViewById<TextView>(R.id.textViewServicio)
        textViewServicio.text = "Servicio: ${reserva?.servicio}"

        val textViewFechaEntrada = itemView.findViewById<TextView>(R.id.textViewFechaEntrada)
        textViewFechaEntrada.text = "Fecha de entrada: ${reserva?.fechaEntrada}"

        val textViewFechaSalida = itemView.findViewById<TextView>(R.id.textViewFechaSalida)
        textViewFechaSalida.text = "Fecha de salida: ${reserva?.fechaSalida}"

        return itemView
    }
}
