import com.ismachat.OptionRequestFilter
import com.ismachat.UserPasswordEncoderListener

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    optionRequestFilter(OptionRequestFilter)
}
