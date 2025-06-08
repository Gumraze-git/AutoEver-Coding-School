<script setup>
const emit = defineEmits(["click"]);

const onClick = (event) => {
  emit("click", event);
};

defineProps({
  disabled: { Boolean },
  input: { String },
});
</script>

<template>
  <button
    :disabled="disabled"
    @click="onClick"
    class="w-[400px] h-[50px] border-none text-white text-[18px] font-medium rounded-lg bg-black disabled:bg-gray-500"
  >
    {{ input }}
  </button>
</template>
