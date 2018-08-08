package rahul.nirmesh.mvvmsample.viewModel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import rahul.nirmesh.mvvmsample.interfaces.LoginResultCallbacks;
import rahul.nirmesh.mvvmsample.model.User;

public class LoginViewModel extends ViewModel {

    private User user;
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
        this.user = new User();
    }

    // method to get Email from EditText and set to User
    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    // method to get Password from EditText and set to User
    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    public void onLoginClick(View view) {
        int loginCode = user.isValidData();

        if (loginCode == 0)
            loginResultCallbacks.onResultError("You must enter your Email Id");
        else if (loginCode == 1)
            loginResultCallbacks.onResultError("You must enter a valid Email Id");
        else if (loginCode == 2)
            loginResultCallbacks.onResultError("Password should be greater than 6");
        else
            loginResultCallbacks.onResultSuccess("Login Successfully Done.");
    }
}
