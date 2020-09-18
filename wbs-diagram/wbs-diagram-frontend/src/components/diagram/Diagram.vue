<template>
<div>
  <ul class="tree">
    <li> <span @contextmenu.prevent="rightClick">EN</span>
      <ul>
        <li>
          <span>FO</span>
          <ul>
            <li><span>REST</span></li>
            <li><span>Frontend</span></li>
          </ul>
        </li>
        <li>
          <span>BO</span>
          <ul>
            <li><span>Web</span></li>
            <li><span>Robot</span></li>
          </ul>
        </li>
        <li><span>CLS</span></li>
      </ul>
    </li>
  </ul>
</div>
</template>

<script>
export default {
  name: "Diagram",
  methods: {
    rightClick() {
      alert("dupa")
    }
  }
}
</script>

<style scoped src="@/assets/css/diagram.css">
</style>
