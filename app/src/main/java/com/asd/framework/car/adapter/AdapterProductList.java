package com.asd.framework.car.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.asd.framework.R;
import com.asd.framework.car.ProductCheckoutActivity;
import com.asd.framework.car.ProductDetailsActivity;
import com.asd.framework.car.beans.Product;
import com.asd.framework.utils.AppLogger;

import java.util.List;


public class AdapterProductList extends ArrayAdapter {


    private Context mContext;
    private List<Product> productList;

    public AdapterProductList(Context context, List<Product> arrayList) {
    super(context, 0, arrayList);
        mContext = context;
        this.productList = arrayList;

    }


    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        final LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = mInflater.inflate(R.layout.item_list_car, parent, false);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.titleName);
            holder.txtSubTitle = (TextView) convertView.findViewById(R.id.txtCompany);
            holder.txtModelNumber = (TextView) convertView.findViewById(R.id.txtModelNumber);
            holder.txtAvailableSeat = (TextView) convertView.findViewById(R.id.txtAvailableSeat);
            holder.txtPerDayCharge = (TextView) convertView.findViewById(R.id.txtPerDayCharge);
            holder.txtAvailableStatus = (TextView) convertView.findViewById(R.id.txtAvailableStatus);

            holder.imageViewFav = (ImageView) convertView.findViewById(R.id.imageViewFav);
            holder.imageViewIcon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
            holder.imageViewSelect = (ImageView) convertView.findViewById(R.id.imageViewSelect);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtTitle.setText(productList.get(position).getTitle());
        holder.txtSubTitle.setText(productList.get(position).getSubTitle());
        holder.txtModelNumber.setText(productList.get(position).getModelNumber());
        holder.txtAvailableSeat.setText(""+ productList.get(position).getSeats() + "Seats");
        holder.txtPerDayCharge.setText("$ " +productList.get(position).getDailyChargeRate());

        if (productList.get(position).getAvailableStatus().equalsIgnoreCase("Available")) {
            holder.txtAvailableStatus.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            holder.imageViewSelect.setImageResource(R.drawable.ic_select_item);
            holder.imageViewSelect.setClickable(true);
        } else {
            holder.txtAvailableStatus.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.imageViewSelect.setImageResource(R.drawable.ic_unselect_item);
            holder.imageViewSelect.setClickable(false);
        }
        holder.txtAvailableStatus.setText(productList.get(position).getAvailableStatus());

        int resId = mContext.getResources().getIdentifier(productList.get(position).getIconName(), "drawable", mContext.getPackageName());
        holder.imageViewIcon.setImageResource(resId);

        holder.imageViewSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext.getApplicationContext(), ProductCheckoutActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Product selectedProduct = productList.get(position);
                intent.putExtra("SELECTED_PRODUCT", selectedProduct);
                mContext.startActivity(intent);
            }
        });


        return convertView;
    }

    class ViewHolder {

        TextView txtTitle;
        TextView txtSubTitle;
        TextView txtModelNumber;
        TextView txtPerDayCharge;
        TextView txtAvailableSeat;
        TextView txtAvailableStatus;

        ImageView imageViewFav;
        ImageView imageViewIcon;
        ImageView imageViewSelect;
    }
}
