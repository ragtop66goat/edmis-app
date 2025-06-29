// src/routes/AppRouter.tsx
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "../pages/home-page/home-page";
import NotFound from "../pages/not-found/not-found";
import { RegisterStudent } from "../pages/register-student/register-student";
import StudentDetail from "../pages/student-detail/student-detail";
import StudentList from "../pages/student-list/student-list";
import SubjectList from "../pages/subject-list/subject-list";

const AppRouter = () => (
  <Router>
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/students" element={<StudentList />} />
      <Route path="/students/:id" element={<StudentDetail />} />
      <Route path="/subjects" element={<SubjectList />} />
      <Route path="/register-student" element={<RegisterStudent />} />
      <Route path="*" element={<NotFound />} />
    </Routes>
  </Router>
);

export default AppRouter;
