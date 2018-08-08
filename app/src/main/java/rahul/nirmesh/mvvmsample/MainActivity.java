package rahul.nirmesh.mvvmsample;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import rahul.nirmesh.mvvmsample.databinding.ActivityMainBinding;
import rahul.nirmesh.mvvmsample.interfaces.LoginResultCallbacks;
import rahul.nirmesh.mvvmsample.viewModel.LoginViewModel;
import rahul.nirmesh.mvvmsample.viewModel.LoginViewModelFactory;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this,
                new LoginViewModelFactory(this)).get(LoginViewModel.class));
    }

    @Override
    public void onResultSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResultError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}
