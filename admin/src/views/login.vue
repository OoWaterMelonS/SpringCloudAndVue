<template>
  <div class="main-container">
    <div class="main-content">
      <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
          <div class="login-container">
            <div class="center">
              <h1>
                <i class="ace-icon fa fa-leaf green"></i>
                <span class="red">EaApple</span>
                <!--                  <span class="white" id="id-text2">Application</span>-->
              </h1>
<!--              <h4 class="blue" id="id-company-text">&copy; OoWaterMelons</h4>-->
            </div>

            <div class="space-6"></div>

            <div class="position-relative">
              <div id="login-box" class="login-box visible widget-box no-border">
                <div class="widget-body">
                  <div class="widget-main">
                    <h4 class="header blue lighter bigger">
                      <i class="ace-icon fa fa-coffee green"></i>
                      login
                    </h4>

                    <div class="space-6"></div>

                    <form>
                      <fieldset>
                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Username" />
															<i class="ace-icon fa fa-user"></i>
														</span>
                        </label>

                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
                        </label>

                        <div class="space"></div>

                        <div class="clearfix">
                          <label class="inline">
                            <input type="checkbox" class="ace" />
                            <span class="lbl"> Remember Me</span>
                          </label>

                          <button type="button"
                                  class="width-35 pull-right btn btn-sm btn-primary"
                                  v-on:click="login()">
                            <i class="ace-icon fa fa-key"></i>
                            <span class="bigger-110">Login</span>
                          </button>
                        </div>

                        <div class="space-4"></div>
                      </fieldset>
                    </form>
                    <div class="space-6"></div>
                  </div><!-- /.widget-main -->
                </div><!-- /.widget-body -->
              </div><!-- /.login-box -->
            </div><!-- /.position-relative -->
          </div>
        </div><!-- /.col -->
      </div><!-- /.row -->
    </div><!-- /.main-content -->
  </div>
</template>

<script>

export default {
  name: 'login',
  mounted:function (){
    $('body').remove('class', 'no-skin');
    $('body').attr('class', 'login-layout light-login');
  },
  methods:{
    login(){
      this.$router.push("/welcome")
    }
  }
}
</script>
