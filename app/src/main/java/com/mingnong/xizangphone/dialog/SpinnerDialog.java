package com.mingnong.xizangphone.dialog;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by zhyzh on 2016/12/20.
 */

public class SpinnerDialog extends Dialog {

    public SpinnerDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    private static class Params {
        private String title = "哈哈";
        private boolean shadow = true;
        private boolean canCancel = true;
        private OnClickListener listener;
    }

    public static class Builder {
        private Context context;
        private Params params;

        public Builder(Context context) {
            this.context = context;
            params = new Params();
        }

        public Builder setTitle(String title) {
            params.title = title;
            return this;
        }

        public Builder setListener(OnClickListener listener) {
            params.listener = listener;
            return this;
        }

        public Builder setCancel(boolean canCancel) {
            params.canCancel = canCancel;
            return this;
        }

//        public SpinnerDialog create() {
//            final SpinnerDialog dialog = new SpinnerDialog(context, params.shadow ? R.style.Theme_Light_NoTitle_Dialog : R.style.Theme_Light_NoTitle_NoShadow_Dialog);
//            View view = LayoutInflater.from(context).inflate(R.layout.spinner_dialog, null);
//            Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
//            CodeXDDao dao = DBExternalController.getDaoSession().getCodeXDDao();
//            List<CodeXD> list = dao.queryBuilder().build().list();
//            ArrayList<String> datas = new ArrayList<>();
//            for (int i = 0; i < list.size(); i++) {
//                datas.add(list.get(i).getCName());
//            }
//            spinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_dropdown_item_1line, datas));
//            view.findViewById(R.id.dialog_quxiao).setOnClickListener(v -> dialog.dismiss());
//            view.findViewById(R.id.dialog_queding).setOnClickListener(v -> {
//                if (params.listener != null) {
//                    params.listener.onClick(spinner.getSelectedItem().toString());
//                }
//                dialog.dismiss();
//            });
//            Window window = dialog.getWindow();
//            window.getDecorView().setPadding(0, 0, 0, 0);
//            WindowManager.LayoutParams attributes = window.getAttributes();
//            attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
//            WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//            attributes.width = (int) (manager.getDefaultDisplay().getWidth()*0.7f);
//            window.setGravity(Gravity.CENTER);
//            dialog.setTitle(params.title);
//            dialog.setCanceledOnTouchOutside(params.canCancel);
//            dialog.setCancelable(params.canCancel);
//            dialog.setContentView(view);
//            return dialog;
//        }
    }

    public interface OnClickListener {
        void onClick(String selectSterilize);
    }


}
