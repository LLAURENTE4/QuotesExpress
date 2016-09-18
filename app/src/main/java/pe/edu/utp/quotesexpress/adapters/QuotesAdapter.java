package pe.edu.utp.quotesexpress.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.utp.quotesexpress.R;
import pe.edu.utp.quotesexpress.models.Quote;

/**
 * Created by GrupoUTP on 17/09/2016.
 */
public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder>{

    private List<Quote> quotes;

    public QuotesAdapter(List<Quote> quotes) {
        this.quotes = quotes;
    }


    @Override

    //ViewGroup parent una vista principal
    public QuotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //view tiene que representar al card
        // genera una vista dinamica en el tiempo de ejecucion pide de donde y cual es la plantilla que usara para cada vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_quote,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    // se encarcara de la vista de los datos
    public void onBindViewHolder(QuotesAdapter.ViewHolder holder, int position) {
        holder.phraseTextView.setText(quotes.get(position).getPhrase());
        holder.authorTextView.setText(quotes.get(position).getAuthor());
        holder.pictureimageView.setImageResource(Integer.parseInt(quotes.get(position).getPictureUri()));
    }

    @Override
    public int getItemCount() {
//        retorna la cantidad de elementos
        return quotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        objeto que se vincula con el card view
        CardView quoteCardView;
        TextView phraseTextView;
        TextView authorTextView;
        ImageView pictureimageView;
        //itemView refencia a la vista principal
        public ViewHolder(View itemView) {
            super(itemView);
            quoteCardView =(CardView) itemView.findViewById(R.id.quoteCardView);
            phraseTextView=(TextView) itemView.findViewById(R.id.phraseTextView);
            authorTextView =(TextView) itemView.findViewById(R.id.authorTextView);
            pictureimageView=(ImageView) itemView.findViewById(R.id.pictureImageViewer);
        }
    }
}
