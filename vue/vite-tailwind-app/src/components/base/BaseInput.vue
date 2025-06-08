<script setup>
import { useAttrs } from "vue";

const props = defineProps({
  type: {
    type: String,
    default: "text",
  },
  placeHolder: {
    type: String,
    default: "",
  },
  id: {
    type: String,
    default: "",
  },
  modelValue: {
    type: String,
    default: "",
  },
  validMessage: {
    type: Boolean,
    default: false,
  },
  validDup: {
    type: String,
    default: "invalid",
  },
});

const emit = defineEmits(["update:modelValue"]);
const attrs = useAttrs();
const updateValue = (event) => {
  emit("update:modelValue", event.target.value);
};
</script>

<template>
  <div class="h-[70px]">
    <input
      v-bind="$attrs"
      class="w-[400px] h-[50px] rounded-lg border-none bg-[#efeded] transition duration-300 ease-in-out pl-3 font-medium text-[18px] placeholder-black placeholder:text-[16px]"
      :type="type"
      :id="id"
      :placeholder="placeHolder"
      :value="modelValue"
      @input="updateValue"
    />
    <span v-if="validMessage !== false" class="flex justify-end m-0 p-0">
      <p
        class="text-sm"
        :class="
          validDup === 'valid' || validDup === true
            ? 'text-green-500'
            : 'text-red-500'
        "
      >
        {{
          validDup === "valid" || validDup === true
            ? "사용 가능 합니다."
            : validDup === "duplicate"
            ? "중복된 이메일 입니다."
            : "사용 불가합니다."
        }}
      </p>
    </span>
  </div>
</template>
