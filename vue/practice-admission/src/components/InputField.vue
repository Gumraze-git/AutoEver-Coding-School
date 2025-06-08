<template>
  <div class="signup__form-group">
    <input
      :type="type"
      :placeHolder="placeHolder"
      v-model="modelValue"
      @input="onInput"
    />
    <span :style="{ color: isValid ? 'green' : 'red' }">
      {{ isValid ? successMsg : errorMsg }}
    </span>
  </div>
</template>

<script setup>
// update:modelValue 이벤트 이름을 등록하여 부모 컴포넌트가 수신할 이벤트를 명시한다.
const emit = defineEmits(["update:modelValue"]);

const onInput = (event) => {
  // emit(): defineEmits로 생성된 이벤트 발신 함수
  // update:modelValue: 이벤트 이름
  // event.targe: 이벤트가 실제로 발생한 DOM 요소 참조
  // event.target.value: 입력창에서 가져온 실제 입력값
  emit("update:modelValue", event.target.value);
};

defineProps({
  modelValue: String,
  placeHolder: String,
  type: { type: String, default: "text" },
  isValid: Boolean,
  successMsg: String,
  errorMsg: String,
});
</script>
