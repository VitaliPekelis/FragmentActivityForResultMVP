package com.vitali.fragmentactivityforesultmvp;

import android.os.Bundle;

public interface GetResultAgreement {
     interface View {
     }

    interface Presenter {
        void setView(GetResultAgreement.View view);
        Bundle getResult();
    }
}
    