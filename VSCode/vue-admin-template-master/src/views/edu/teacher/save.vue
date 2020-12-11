<template>
  <div class="app-container">
    讲师添加
    <el-form label-width="120px">
      <el-form-item label="讲师名称">
        <el-input v-model="teacher.name"/>
      </el-form-item>
      <el-form-item label="讲师排序">
        <el-input-number v-model="teacher.sort" controls-position="right" min="0"/>
      </el-form-item>
      <el-form-item label="讲师头衔">
        <el-select v-model="teacher.level" clearable placeholder="请选择">
          <!--
            数据类型一定要和取出的json中的一致，否则没法回填
            因此，这里value使用动态绑定的值，保证其数据类型是number
          -->
          <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/>
        </el-select>
      </el-form-item>
      <el-form-item label="讲师资历">
        <el-input v-model="teacher.career"/>
      </el-form-item>
      <el-form-item label="讲师简介">
        <el-input v-model="teacher.intro" :rows="10" type="textarea"/>
      </el-form-item>

      
      <!-- 讲师头像 -->
<el-form-item label="讲师头像">
    <!-- 头衔缩略图 -->
    <pan-thumb :image="teacher.avatar"/>
    <!-- 文件上传按钮 -->
    <el-button type="primary" icon="el-icon-upload" @click="test">更换头像
    </el-button>
    <!--
v-show：是否显示上传组件
:key：类似于id，如果一个页面多个图片上传控件，可以做区分
:url：后台上传的url地址
@close：关闭上传组件
@crop-upload-success：上传成功后的回调 -->
    <image-cropper
                   v-show="imagecropperShow"
                   :width="300"
                   :height="300"
                   :key="imagecropperKey"
                   :url="BASE_API+'eduoss/fileoss'"
                   field="file"
                   @close="close"
                   @crop-upload-success="cropSuccess"/>
</el-form-item>


      
      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import teacher from '@/api/edu/teacher'
import ImageCropper from '@/components/ImageCropper'
import PanThumb from '@/components/PanThumb'
export default {
  component: { ImageCropper, PanThumb},
  data() {
    return {
      teacher: {
        name: '',
        sort: 0,
        level: 1,
        career: '',
        intro: '',
        avatar: 'https://gitee.com/big-suns/image/raw/master/image/test3.jpg'
      },
      //上传弹框组件是否显示
      imagecropperShow:false,
      imagecropperKey:0,//上传组件key值
      BASE_API:process.env.BASE_API,//获取dev.env.js里面的地址
      saveBtnDisabled: false// 保存按钮是否禁用,
      
    }
  },
  
  //创建页面时调用的方法
  created() {
      console.log('created')
      this.init()
  },
  //监听
  //监听路由变化
    watch: {
    $route(to, from) {
      console.log('watch $route')
      this.init()
    }
  },
  
  methods: {
    //init方法,监听到路由变化后执行
    init() {
      if (this.$route.params && this.$route.params.id) {
        const id = this.$route.params.id
        // console.log(id)
        this.fetchDataById(id)
        // console.log("after")
      } else {
        //清空表单
        // this.teacher = {}
      }
    },
    
    //根据讲师id查询的方法
    getInfo(id) {
      teacher.getTeacherInfo(id)
        .then(response =>{
          this.teacher = response.data.teacher
          // console.log(teacher)
        })
    },
    saveOrUpdate() {
      if(!this.teacher.id) {
        //添加
        this.saveTeacher()
      } else {
        this.updateTeacher()
      }
      this.saveBtnDisabled = true
    },
    // 保存
    saveTeacher() {
        teacher.addTeacher(this.teacher)
        .then(response => {//添加成功
            //提示信息
            this.$message({
                type: 'success',
                message: '添加成功!'
            })
            
        })
        //回到列表页面 路由跳转
        this.$router.push({path:'/teacher/table'})
    },
    //修改讲师的方法
    updateTeacher() {
        teacher.updateTeacherInfo(this.teacher)
        .then(response => {//添加成功
            //提示信息
            this.$message({
                type: 'success',
                message: '修改成功!'
            })
        })
        //回到列表页面 路由跳转
        this.$router.push({path:'/teacher/table'})
    },
    
    
    // 根据id查询记录
    fetchDataById(id) {
      // console.log("fetchDataById")
        teacher.getTeacherInfo(id).then(response => {
            this.teacher = response.data.teacher
            })
            .catch((response) => {
                this.$message({
                type: 'error',
                message: '获取数据失败'
         })
      })
    },
    cropSuccess(data) {
      console.log(data)
      this.imagecropperShow = false
      this.teacher.avatar = data.url
      // 上传成功后，重新打开上传组件时初始化组件，否则显示上一次的上传结果
      this.imagecropperKey = this.imagecropperKey + 1
    },
    // 关闭上传组件
    close() {
      this.imagecropperShow = false
      // 上传失败后，重新打开上传组件时初始化组件，否则显示上一次的上传结果
      this.imagecropperKey = this.imagecropperKey + 1
    },
    test() {
      alert("test")
    },
    
    
  }
}
</script>